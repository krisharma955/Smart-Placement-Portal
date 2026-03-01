package com.K955.Placement_Portal.DTOs.Auth;

import com.K955.Placement_Portal.Enums.Role;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        String name,
        String email,
        Role role
) {
}
