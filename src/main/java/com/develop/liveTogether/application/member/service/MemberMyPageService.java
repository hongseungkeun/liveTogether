package com.develop.liveTogether.application.member.service;

import com.develop.liveTogether.application.member.domain.Member;
import com.develop.liveTogether.application.member.dto.request.UpdateMemberInfoRequest;
import com.develop.liveTogether.application.member.dto.response.MemberInfoResponse;
import com.develop.liveTogether.application.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberMyPageService {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberInfoResponse getMyInfo(String memberId) {
        Member member = memberService.findMemberById(memberId);

        return MemberInfoResponse.toDTO(member, memberService.decodeMemberPw(member.getMemberPw()));
    }

    public MemberInfoResponse updateMyInfo(String memberId, UpdateMemberInfoRequest request) {
        Member member = memberService.findMemberById(memberId);

        member.updateMyInfo(request, memberService.encodeMemberPw(member.getMemberPw()));

        return MemberInfoResponse.toDTO(member, memberService.decodeMemberPw(member.getMemberPw()));
    }
}
