package com.develop.liveTogether.application.house.dto.request;

import com.develop.liveTogether.application.house.data.Status;

public record HouseAdminChangeStatusRequest(
        Status status
) {
}
