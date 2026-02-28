package com.K955.Placement_Portal.DTOs.JobPosting;

import com.K955.Placement_Portal.Enums.JobType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

public record JobPostingRequest(

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        String location,

        Double minSalary,

        Double maxSalary,

        @NotNull
        JobType jobType,

        List<String> skills,

        @NotNull
        @Min(1)
        Integer openings,

        @NotNull
        @Future
        Instant deadline

) {
}
