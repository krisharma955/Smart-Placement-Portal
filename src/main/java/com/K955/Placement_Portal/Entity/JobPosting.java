package com.K955.Placement_Portal.Entity;

import com.K955.Placement_Portal.Enums.JobType;
import com.K955.Placement_Portal.Enums.JobPostingStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_posting")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    String location;

    Double minSalary;

    Double maxSalary;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    JobType jobType;

    @Builder.Default
    @ElementCollection
    List<String> requiredSkills = new ArrayList<>();

    @Column(nullable = false)
    Integer openings;

    @Builder.Default
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    JobPostingStatus jobPostingStatus = JobPostingStatus.OPEN;

    @Column(updatable = false)
    @CreationTimestamp
    Instant postedAt;

    @UpdateTimestamp
    Instant updatedAt;

    @Column(nullable = false)
    Instant deadline;

}
