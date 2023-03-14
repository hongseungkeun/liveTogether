package com.develop.liveTogether.application.member.service;

import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.dto.JoinRequest;
import com.develop.liveTogether.application.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public void signUp(JoinRequest request) {
        validateRequest(request.memberId(), request.memberNickname());

        Member member = request.toMember();

        memberRepository.save(member);
    }

    public void login(){

    }

    private void validateRequest(String memberId, String memberNickname) {
        if(memberRepository.existsById(memberId)){

        }
        if(memberRepository.existsByNickname(memberNickname)){

        }
    }
}
