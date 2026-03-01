package com.K955.Placement_Portal.Service;

import com.K955.Placement_Portal.DTOs.Auth.AuthResponse;
import com.K955.Placement_Portal.DTOs.Auth.LoginRequest;
import com.K955.Placement_Portal.DTOs.Auth.RefreshTokenRequest;
import com.K955.Placement_Portal.DTOs.Auth.SignupRequest;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    AuthResponse signup(@Valid SignupRequest request);

    AuthResponse login(@Valid LoginRequest request);

    AuthResponse refreshToken(@Valid RefreshTokenRequest request);

    void logout(String token);
}
