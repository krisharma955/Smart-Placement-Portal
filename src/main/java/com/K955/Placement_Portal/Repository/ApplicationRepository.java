package com.K955.Placement_Portal.Repository;

import com.K955.Placement_Portal.Entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByStudentId(Long studentId);

    List<Application> findByJobPostingId(Long jobId);

    Boolean existsByStudentIdAndJobPostingId(Long studentId, Long jobId);

}
