package com.todo.studentcoursesystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_code", nullable = false,unique = true)
    private String courseCode;

    @Column(name = "credits", nullable = false)
    private int credits;

    @Column(name = "duration_in_weeks", nullable = false)
    private Integer duration;
}
