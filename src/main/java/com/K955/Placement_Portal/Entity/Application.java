package com.K955.Placement_Portal.Entity;

import com.K955.Placement_Portal.Enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "application",
        uniqueConstraints = @UniqueConstraint(
        columnNames = {"student_id", "job_posting_id"}
))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_posting_id")
    JobPosting jobPosting;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    ApplicationStatus applicationStatus = ApplicationStatus.APPLIED;

    @Column(nullable = false)
    @CreationTimestamp
    Instant appliedAt;

    @UpdateTimestamp
    Instant updatedAt;

    Instant deletedAt;

}
