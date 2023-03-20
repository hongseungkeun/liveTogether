package com.develop.liveTogether.application.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ValidateIdRequest(
        @NotBlank String memberId) {
}
