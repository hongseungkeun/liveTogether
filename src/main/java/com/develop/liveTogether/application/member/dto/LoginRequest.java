package com.develop.liveTogether.application.member.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank String memberId, @NotBlank String memberPw) {
}
