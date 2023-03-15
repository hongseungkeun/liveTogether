package com.develop.liveTogether.application.member.dto.request;

import com.develop.liveTogether.application.member.domain.Member;
import jakarta.validation.constraints.NotBlank;

import java.util.Base64;

public record JoinRequest(@NotBlank String memberId, @NotBlank String memberPw,
                          @NotBlank String memberName, @NotBlank String memberNickname,
                          @NotBlank String memberPhone, @NotBlank String memberGender,
                          @NotBlank String memberProfile, @NotBlank String memberRole)
{
    public Member toMember(String memberPw){
        return new Member(
                this.memberId, memberPw,
                this.memberName, this.memberNickname,
                this.memberPhone,this.memberGender,
                this.memberProfile,this.memberRole);
    }
}
