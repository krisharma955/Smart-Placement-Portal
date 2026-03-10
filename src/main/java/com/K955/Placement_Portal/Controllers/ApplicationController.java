package com.K955.Placement_Portal.Controllers;

import com.K955.Placement_Portal.DTOs.Application.ApplicationResponse;
import com.K955.Placement_Portal.DTOs.Application.UpdateApplicationStatusRequest;
import com.K955.Placement_Portal.Security.JwtUtil;
import com.K955.Placement_Portal.Service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    private final JwtUtil jwtUtil;

    @PostMapping("/{jobId}")
    public ResponseEntity<ApplicationResponse> createApplication(@PathVariable Long jobId) {
        Long userId = jwtUtil.getCurrentUserId();
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.createApplication(userId, jobId));
    }

    @GetMapping("/{applicationId}")
    public ResponseEntity<ApplicationResponse> getApplication(@PathVariable Long applicationId) {
        return ResponseEntity.ok(applicationService.getApplicationById(applicationId));
    }

    @GetMapping("/student")
    public ResponseEntity<List<ApplicationResponse>> getApplicationsByStudent() {
        Long userId = jwtUtil.getCurrentUserId();
        return ResponseEntity.ok(applicationService.getApplicationsByStudent(userId));
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationResponse>> getApplicationsByJob(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getApplicationsByJob(jobId));
    }

    @PatchMapping("/{applicationId}/status")
    public ResponseEntity<ApplicationResponse> updateApplicationStatus(@PathVariable Long applicationId,
                                                                       @Valid @RequestBody UpdateApplicationStatusRequest request) {
        return ResponseEntity.ok(applicationService.updateApplicationStatus(applicationId, request));
    }

    @DeleteMapping("/{applicationId}")
    public ResponseEntity<Void> withdrawApplication(@PathVariable Long applicationId) {
        applicationService.withdrawApplication(applicationId);
        return ResponseEntity.noContent().build();
    }

}
