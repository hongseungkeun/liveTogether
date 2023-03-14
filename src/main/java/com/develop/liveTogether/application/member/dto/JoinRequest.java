package com.develop.liveTogether.application.member.dto;

import com.develop.liveTogether.application.member.domain.Member;
import jakarta.validation.constraints.NotBlank;

import java.util.Base64;

public record JoinRequest(@NotBlank String memberId, @NotBlank String memberPw,
                          @NotBlank String memberName, @NotBlank String memberNickname,
                          @NotBlank String memberPhone, @NotBlank String memberGender,
                          @NotBlank String memberProfile, @NotBlank String memberRole)
{
    public Member toMember(){
        return new Member(
                this.memberId, Base64.getEncoder().encodeToString(this.memberPw.getBytes()),
                this.memberName, this.memberNickname,
                this.memberPhone,this.memberGender,
                this.memberProfile,this.memberRole);
    }
}
