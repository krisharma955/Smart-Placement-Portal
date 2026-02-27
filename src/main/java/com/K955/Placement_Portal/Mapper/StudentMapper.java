package com.K955.Placement_Portal.Mapper;

import com.K955.Placement_Portal.DTOs.Student.StudentProfileRequest;
import com.K955.Placement_Portal.DTOs.Student.StudentProfileResponse;
import com.K955.Placement_Portal.Entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "profileComplete", ignore = true)
    Student toStudent(StudentProfileRequest request);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.email", target = "email")
    StudentProfileResponse toStudentProfileResponse(Student student);

}
