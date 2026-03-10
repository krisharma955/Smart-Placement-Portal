package com.K955.Placement_Portal.Mapper;

import com.K955.Placement_Portal.DTOs.Resume.ResumeResponse;
import com.K955.Placement_Portal.Entity.Resume;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    ResumeResponse toResumeResponse(Resume resume);

}
