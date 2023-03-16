package com.develop.liveTogether.application.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ChangePwRequest(@NotBlank String memberId, @NotBlank String memberPw) {
}
