package com.K955.Placement_Portal.Service;

import com.K955.Placement_Portal.DTOs.Student.StudentProfileRequest;
import com.K955.Placement_Portal.DTOs.Student.StudentProfileResponse;
import com.K955.Placement_Portal.DTOs.Student.UpdateStudentRequest;
import jakarta.validation.Valid;

public interface StudentService {
    StudentProfileResponse createStudentProfile(Long userId, @Valid StudentProfileRequest request);

    StudentProfileResponse getStudentProfileById(Long userId);

    StudentProfileResponse updateStudentProfileById(Long userId, @Valid UpdateStudentRequest request);

    void deleteStudentProfileById(Long userId);
}
