package com.develop.liveTogether.application.member.service;

import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.dto.response.MemberInfoResponse;
import com.develop.liveTogether.application.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberMyService {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberInfoResponse getMyInfo(String memberId) {
        Member member = memberService.findMemberById(memberId);

        return MemberInfoResponse.toDTO(member, decodeMemberPw(member.getMemberPw()));
    }

    private String decodeMemberPw(String memberPw){
        return new String(Base64.getDecoder().decode(memberPw.getBytes()));
    }
}
