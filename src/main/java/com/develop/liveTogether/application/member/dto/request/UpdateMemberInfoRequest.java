package com.develop.liveTogether.application.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateMemberInfoRequest(
        @NotBlank String memberPw,
        @NotBlank String memberNickname,
        @NotBlank String memberPhone,
        @NotBlank String memberProfile
) {
}
