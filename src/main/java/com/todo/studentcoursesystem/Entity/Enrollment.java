package com.todo.studentcoursesystem.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDateTime enrollmentDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
