package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Status;
import jakarta.validation.constraints.NotNull;

public record HouseAdminChangeStatusRequest(
        @NotNull Status status
) {
}
