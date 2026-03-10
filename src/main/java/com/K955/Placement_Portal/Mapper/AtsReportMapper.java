package com.K955.Placement_Portal.Mapper;

import com.K955.Placement_Portal.DTOs.Resume.AtsReportResponse;
import com.K955.Placement_Portal.Entity.AtsReport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AtsReportMapper {

    List<AtsReportResponse> toListOfAtsReportResponse(List<AtsReport> atsReportList);

    AtsReportResponse toAtsReportResponse(AtsReport atsReport);

}
