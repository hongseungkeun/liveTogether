package com.develop.liveTogether.application.member.dto;

import jakarta.validation.constraints.NotBlank;

public record FindIdRequest(@NotBlank String memberName, @NotBlank String memberPhone) {
}
