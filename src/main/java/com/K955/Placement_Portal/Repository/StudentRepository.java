package com.K955.Placement_Portal.Repository;

import com.K955.Placement_Portal.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUserId(Long userId);

    Boolean existsByUserId(Long userId);

}
