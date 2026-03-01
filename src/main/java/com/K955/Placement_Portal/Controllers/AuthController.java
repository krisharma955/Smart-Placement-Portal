package com.K955.Placement_Portal.Controllers;

import com.K955.Placement_Portal.DTOs.Auth.AuthResponse;
import com.K955.Placement_Portal.DTOs.Auth.LoginRequest;
import com.K955.Placement_Portal.DTOs.Auth.RefreshTokenRequest;
import com.K955.Placement_Portal.DTOs.Auth.SignupRequest;
import com.K955.Placement_Portal.Repository.UserRepository;
import com.K955.Placement_Portal.Security.JwtUtil;
import com.K955.Placement_Portal.Service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(authService.refreshToken(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        String requestHeader = request.getHeader("Authorization");
        if(requestHeader != null && requestHeader.startsWith("Bearer ")) {
            String token = requestHeader.substring(7);
            authService.logout(token);
        }
        return ResponseEntity.noContent().build();
    }

}
