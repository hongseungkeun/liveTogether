package com.develop.liveTogether.application.member.service;

import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.dto.request.*;
import com.develop.liveTogether.application.member.dto.response.FindIdResponse;
import com.develop.liveTogether.application.member.exception.DuplicatedMemberIdException;
import com.develop.liveTogether.application.member.exception.DuplicatedNicknameException;
import com.develop.liveTogether.application.member.exception.LoginFailedException;
import com.develop.liveTogether.application.member.exception.MemberNotFoundException;
import com.develop.liveTogether.application.member.repository.MemberRepository;
import com.develop.liveTogether.global.exception.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void signUp(JoinRequest request) {
        isDuplicated(request.memberId(), request.memberNickname());

        Member member = request.toMember(encodeMemberPw(request.memberPw()));

//        af.setPath(req.getContextPath() + "/member/login.jsp");
        memberRepository.save(member);
    }

    public String login(LoginRequest request){
        Member member = isPossibleLogin(request.memberId(), encodeMemberPw(request.memberPw()));

        return member.getMemberId();
    }

    public FindIdResponse findId(FindIdRequest request) {
        Member member = memberRepository.findByMemberNameAndMemberPhone(request.memberName(), request.memberPhone())
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        return FindIdResponse.toDto(member.getMemberId());
    }

    public void findPw(FindPwRequest request) {
        Member member = memberRepository.findByMemberIdAndMemberPhone(request.memberId(), request.memberPhone())
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));
    }

    public void changePw(ChangePwRequest request) {
        Member member = findMemberById(request.memberId());
        member.changePassword(encodeMemberPw(request.memberPw()));
    }

    public void withdrawal(String memberId) {
        memberRepository.deleteById(memberId);
    }

    public void isDuplicatedMemberId(String memberId) {
        if(memberRepository.existsById(memberId)){
            throw new DuplicatedMemberIdException(ErrorCode.EXIST_MEMBER_ID);
        }
    }

    public void isDuplicatedMemberNickname(String memberNickname) {
        if(memberRepository.existsByMemberNickname(memberNickname)){
            throw new DuplicatedNicknameException(ErrorCode.EXIST_MEMBER_NICKNAME);
        }
    }

    public Member findMemberById(String memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new LoginFailedException(ErrorCode.LOGIN_FAILED));
    }

    public String encodeMemberPw(String memberPw){
        return Base64.getEncoder().encodeToString(memberPw.getBytes());
    }

    public String decodeMemberPw(String memberPw){
        return new String(Base64.getDecoder().decode(memberPw.getBytes()));
    }

    private void isDuplicated(String memberId, String memberNickname){
        isDuplicatedMemberId(memberId);
        isDuplicatedMemberNickname(memberNickname);
    }

    private Member isPossibleLogin(String memberId, String requestMemberPw) {
        Member member = findMemberById(memberId);

        if(!member.getMemberPw().equals(requestMemberPw)){
            throw new LoginFailedException(ErrorCode.LOGIN_FAILED);
        }

        return member;
    }
}
