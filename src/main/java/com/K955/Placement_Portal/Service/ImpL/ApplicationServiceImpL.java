package com.K955.Placement_Portal.Service.ImpL;

import com.K955.Placement_Portal.DTOs.Application.ApplicationResponse;
import com.K955.Placement_Portal.DTOs.Application.UpdateApplicationStatusRequest;
import com.K955.Placement_Portal.Entity.Application;
import com.K955.Placement_Portal.Entity.JobPosting;
import com.K955.Placement_Portal.Entity.Student;
import com.K955.Placement_Portal.Enums.JobPostingStatus;
import com.K955.Placement_Portal.Exceptions.BadRequestException;
import com.K955.Placement_Portal.Exceptions.ResourceNotFoundException;
import com.K955.Placement_Portal.Mapper.ApplicationMapper;
import com.K955.Placement_Portal.Repository.ApplicationRepository;
import com.K955.Placement_Portal.Repository.JobPostingRepository;
import com.K955.Placement_Portal.Repository.StudentRepository;
import com.K955.Placement_Portal.Service.ApplicationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationServiceImpL implements ApplicationService {

    private final StudentRepository studentRepository;
    private final JobPostingRepository jobPostingRepository;
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    @Override
    public ApplicationResponse createApplication(Long userId, Long jobId) {
        Student student = studentRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", userId.toString()));

        JobPosting jobPosting = jobPostingRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("JobPosting", jobId.toString()));

        Boolean check = applicationRepository.existsByStudentIdAndJobPostingId(student.getId(), jobId);
        if(check) throw new BadRequestException("Student has already applied to this job");

        if(jobPosting.getJobPostingStatus().equals(JobPostingStatus.CLOSE)) {
            throw new BadRequestException("Job posting is closed");
        }

        Application application = Application.builder()
                .student(student)
                .jobPosting(jobPosting)
                .build();

        applicationRepository.save(application);

        return applicationMapper.toApplicationResponse(application);
    }

    @Override
    public ApplicationResponse getApplicationById(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application", applicationId.toString()));
        return applicationMapper.toApplicationResponse(application);
    }

    @Override
    public List<ApplicationResponse> getApplicationsByStudent(Long userId) {
        Student student = studentRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", userId.toString()));
        List<Application> applicationList = applicationRepository.findByStudentId(student.getId());
        return applicationMapper.toListOfApplicationResponse(applicationList);
    }

    @Override
    public List<ApplicationResponse> getApplicationsByJob(Long jobId) {
        List<Application> applicationList = applicationRepository.findByJobPostingId(jobId);
        return applicationMapper.toListOfApplicationResponse(applicationList);
    }

    @Override
    public ApplicationResponse updateApplicationStatus(Long applicationId, UpdateApplicationStatusRequest request) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application", applicationId.toString()));

        application.setApplicationStatus(request.applicationStatus());
        Application saved = applicationRepository.save(application);

        return applicationMapper.toApplicationResponse(saved);
    }

    @Override
    public void withdrawApplication(Long applicationId) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ResourceNotFoundException("Application", applicationId.toString()));
        applicationRepository.delete(application);
    }
}
