package com.K955.Placement_Portal.Entity;

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
@Table(name = "resumes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    Student student;

    @Column(nullable = false)
    String fileName;

    @Column(nullable = false)
    String filePath;

    @Column(nullable = false)
    String fileType;

    @Column(nullable = false)
    Long fileSize;

    @Column(nullable = false)
    @CreationTimestamp
    Instant uploadedAt;

}
