package com.K955.Placement_Portal.DTOs.Resume;

import java.time.Instant;
import java.util.List;

public record AtsReportResponse(
        Long id,
        Integer overallScore,
        Integer skillScore,
        Integer experienceScore,
        Integer educationScore,
        Integer formattingScore,
        List<String> missingKeywords,
        List<String> suggestions,
        List<String> strengths,
        Instant createdAt
) {
}
