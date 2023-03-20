package com.develop.liveTogether.application.member.dto.request;

import com.develop.liveTogether.application.member.data.MemberGender;
import com.develop.liveTogether.application.member.data.Role;
import com.develop.liveTogether.application.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record JoinRequest(
        @NotBlank String memberId,
        @NotBlank String memberPw,
        @NotBlank String memberName,
        @NotBlank String memberNickname,
        @NotBlank String memberPhone,
        @NotNull MemberGender memberGender,
        @NotBlank String memberProfile,
        @NotNull Role memberRole) {
    public Member toMember(String memberPw) {
        return Member.builder()
                .memberId(this.memberId)
                .memberPw(memberPw)
                .memberName(this.memberName)
                .memberNickname(this.memberNickname)
                .memberPhone(this.memberPhone)
                .memberGender(this.memberGender)
                .memberProfile(this.memberProfile)
                .memberRole(this.memberRole)
                .build();
    }
}
