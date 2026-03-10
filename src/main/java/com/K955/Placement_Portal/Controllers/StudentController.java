package com.K955.Placement_Portal.Controllers;

import com.K955.Placement_Portal.DTOs.Student.StudentProfileRequest;
import com.K955.Placement_Portal.DTOs.Student.StudentProfileResponse;
import com.K955.Placement_Portal.DTOs.Student.UpdateStudentRequest;
import com.K955.Placement_Portal.Security.JwtUtil;
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
    private final JwtUtil jwtUtil;

    @PostMapping("/profile")
    public ResponseEntity<StudentProfileResponse> createStudentProfile(@Valid @RequestBody StudentProfileRequest request) {
        Long userId = jwtUtil.getCurrentUserId();
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudentProfile(userId, request));
    }

    @GetMapping("/profile")
    public ResponseEntity<StudentProfileResponse> getStudentProfile() {
        Long userId = jwtUtil.getCurrentUserId();
        return ResponseEntity.ok(studentService.getStudentProfileById(userId));
    }

    @PatchMapping("/profile")
    public ResponseEntity<StudentProfileResponse> updateStudentProfile(@Valid @RequestBody UpdateStudentRequest request) {
        Long userId = jwtUtil.getCurrentUserId();
        return ResponseEntity.ok(studentService.updateStudentProfileById(userId, request));
    }

    @DeleteMapping("/profile")
    public ResponseEntity<Void> deleteStudentProfile() {
        Long userId = jwtUtil.getCurrentUserId();
        studentService.deleteStudentProfileById(userId);
        return ResponseEntity.noContent().build();
    }

}
