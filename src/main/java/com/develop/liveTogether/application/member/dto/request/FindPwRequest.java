package com.develop.liveTogether.application.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record FindPwRequest(@NotBlank String memberId, @NotBlank String memberPhone) {
}
