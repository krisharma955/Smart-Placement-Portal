package com.K955.Placement_Portal.Controllers;

import com.K955.Placement_Portal.DTOs.Student.StudentProfileRequest;
import com.K955.Placement_Portal.DTOs.Student.StudentProfileResponse;
import com.K955.Placement_Portal.DTOs.Student.UpdateStudentRequest;
import com.K955.Placement_Portal.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/profile/{userId}")
    public ResponseEntity<StudentProfileResponse> createStudentProfile(@PathVariable Long userId,
                                                                       @Valid @RequestBody StudentProfileRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudentProfile(userId, request));
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<StudentProfileResponse> getStudentProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(studentService.getStudentProfileById(userId));
    }

    @PatchMapping("/profile/{userId}")
    public ResponseEntity<StudentProfileResponse> updateStudentProfile(@PathVariable Long userId,
                                                                       @Valid @RequestBody UpdateStudentRequest request) {
        return ResponseEntity.ok(studentService.updateStudentProfileById(userId, request));
    }

    @DeleteMapping("/profile/{userId}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Long userId) {
        studentService.deleteStudentProfileById(userId);
        return ResponseEntity.noContent().build();
    }

}
