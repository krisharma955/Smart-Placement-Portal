package com.K955.Placement_Portal.DTOs.Resume;

import java.time.Instant;

public record ResumeResponse(
        Long id,
        String fileName,
        String fileType,
        Long fileSize,
        Instant uploadedAt
) {
}
