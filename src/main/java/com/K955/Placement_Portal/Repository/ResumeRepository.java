package com.K955.Placement_Portal.Repository;

import com.K955.Placement_Portal.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

    Optional<Resume> findByStudentUserId(Long userId);

}
