package com.develop.liveTogether.application.member.dto.response;

import com.develop.liveTogether.application.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record MemberInfoResponse(
        String memberId,
        String memberPw,
        String memberName,
        String memberNickname,
        String memberPhone,
        String memberGender,
        String memberProfile
) {
    public static MemberInfoResponse toDTO(Member member, String memberPw){
        return MemberInfoResponse.builder()
                .memberId(member.getMemberId())
                .memberPw(memberPw)
                .memberName(member.getMemberName())
                .memberNickname(member.getMemberNickname())
                .memberPhone(member.getMemberPhone())
                .memberGender(member.getMemberGender().getGender())
                .memberProfile(member.getMemberProfile())
                .build();
    }
}
