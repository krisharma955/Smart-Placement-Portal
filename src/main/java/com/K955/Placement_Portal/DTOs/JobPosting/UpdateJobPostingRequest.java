package com.K955.Placement_Portal.DTOs.JobPosting;

import com.K955.Placement_Portal.Enums.JobType;

import java.time.Instant;
import java.util.List;

public record UpdateJobPostingRequest(
        String title,

        String description,

        String location,

        Double minSalary,

        Double maxSalary,

        JobType jobType,

        List<String> skills,

        Integer openings,

        Instant deadline
) {
}
