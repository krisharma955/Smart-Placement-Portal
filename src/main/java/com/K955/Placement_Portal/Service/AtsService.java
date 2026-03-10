package com.K955.Placement_Portal.Service;

import com.K955.Placement_Portal.DTOs.Resume.AtsReportResponse;

import java.io.IOException;
import java.util.List;

public interface AtsService {
    AtsReportResponse analyzeResume(Long userId) throws IOException;

    List<AtsReportResponse> getAtsHistory(Long userId);

    AtsReportResponse getAtsReport(Long reportId);
}
