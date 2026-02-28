package com.K955.Placement_Portal.DTOs.Application;

import com.K955.Placement_Portal.Enums.ApplicationStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateApplicationStatusRequest(

        @NotNull
        ApplicationStatus applicationStatus
) {
}
