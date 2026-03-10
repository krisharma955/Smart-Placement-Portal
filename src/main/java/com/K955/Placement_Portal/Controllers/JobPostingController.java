package com.K955.Placement_Portal.Controllers;

import com.K955.Placement_Portal.DTOs.JobPosting.JobPostingRequest;
import com.K955.Placement_Portal.DTOs.JobPosting.JobPostingResponse;
import com.K955.Placement_Portal.DTOs.JobPosting.UpdateJobPostingRequest;
import com.K955.Placement_Portal.Security.JwtUtil;
import com.K955.Placement_Portal.Service.JobPostingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jobs")
public class JobPostingController {

    private final JobPostingService jobPostingService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<JobPostingResponse> createJobPosting(@Valid @RequestBody JobPostingRequest request) {
        Long userId = jwtUtil.getCurrentUserId();
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPostingService.createJobPosting(userId, request));
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobPostingResponse> getJobPosting(@PathVariable Long jobId) {
        return ResponseEntity.ok(jobPostingService.getJobPostingById(jobId));
    }

    @GetMapping
    public ResponseEntity<List<JobPostingResponse>> getAllJobPostings() {
        return ResponseEntity.ok(jobPostingService.getAllJobPostings());
    }

    @PatchMapping("/{jobId}")
    public ResponseEntity<JobPostingResponse> updateJobPosting(@PathVariable Long jobId,
                                                               @Valid @RequestBody UpdateJobPostingRequest request) {
        return ResponseEntity.ok(jobPostingService.updateJobPostingById(jobId, request));
    }

    @PatchMapping("/{jobId}/close")
    public ResponseEntity<Void> closeJobPosting(@PathVariable Long jobId) {
        jobPostingService.closeJobPosting(jobId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJobPosting(@PathVariable Long jobId) {
        jobPostingService.deleteJobPosting(jobId);
        return ResponseEntity.noContent().build();
    }

}
