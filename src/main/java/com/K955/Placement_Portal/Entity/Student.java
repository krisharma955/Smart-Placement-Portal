package com.K955.Placement_Portal.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @Column(nullable = false)
    String phoneNumber;

    @Column(nullable = false)
    String college;

    @Column(nullable = false)
    String degree;

    @Column(nullable = false)
    String branch;

    @Column(nullable = false)
    Integer graduationYear;

    @Column(nullable = false)
    Double cgpa;

    @Builder.Default
    @ElementCollection
    List<String> skills = new ArrayList<>();

    @Builder.Default
    Boolean profileComplete = false;

}
