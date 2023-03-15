package com.develop.liveTogether.application.member.service;

import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.dto.request.FindIdRequest;
import com.develop.liveTogether.application.member.dto.request.JoinRequest;
import com.develop.liveTogether.application.member.dto.request.LoginRequest;
import com.develop.liveTogether.application.member.exception.DuplicatedMemberIdException;
import com.develop.liveTogether.application.member.exception.DuplicatedNicknameException;
import com.develop.liveTogether.application.member.exception.LoginFailedException;
import com.develop.liveTogether.application.member.exception.MemberNotFoundException;
import com.develop.liveTogether.application.member.repository.MemberRepository;
import com.develop.liveTogether.global.exception.error.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void signUp(JoinRequest request) {
        isDuplicated(request.memberId(), request.memberNickname());

        Member member = request.toMember(encodeMemberPw(request.memberPw()));

        memberRepository.save(member);
    }

    public void login(LoginRequest request){
        Member member = isPossibleLogin(request.memberId(), encodeMemberPw(request.memberPw()));
    }

    public String findId(FindIdRequest request) {
        Member member = memberRepository.findByMemberNameAndMemberPhone(request.memberName(), request.memberPhone())
                .orElseThrow(() -> new MemberNotFoundException(ErrorCode.MEMBER_NOT_FOUND));

        return member.getMemberId();
    }

    private String encodeMemberPw(String memberPw){
        return Base64.getEncoder().encodeToString(memberPw.getBytes());
    }

    private Member findMemberById(String memberId){
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new LoginFailedException(ErrorCode.LOGIN_FAILED));
    }

    private void isDuplicated(String memberId, String memberNickname) {
        if(memberRepository.existsById(memberId)){
            throw new DuplicatedMemberIdException(ErrorCode.EXIST_MEMBER_ID);
        }

        if(memberRepository.existsByNickname(memberNickname)){
            throw new DuplicatedNicknameException(ErrorCode.EXIST_MEMBER_NICKNAME);
        }
    }

    private Member isPossibleLogin(String memberId, String requestMemberPw) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new LoginFailedException(ErrorCode.LOGIN_FAILED));

        if(!member.getMemberPw().equals(requestMemberPw)){
            throw new LoginFailedException(ErrorCode.LOGIN_FAILED);
        }

        return member;
    }
}
