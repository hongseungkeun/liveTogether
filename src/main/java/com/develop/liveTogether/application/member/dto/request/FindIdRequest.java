package com.develop.liveTogether.application.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record FindIdRequest(@NotBlank String memberName, @NotBlank String memberPhone) {
}
