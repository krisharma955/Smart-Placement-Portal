package com.K955.Placement_Portal.Repository;

import com.K955.Placement_Portal.Entity.AtsReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AtsReportRepository extends JpaRepository<AtsReport, Long> {

    List<AtsReport> findByResumeId(Long resumeId);

    Optional<AtsReport> findTopByResumeIdOrderByCreatedAtDesc(Long resumeId);

}