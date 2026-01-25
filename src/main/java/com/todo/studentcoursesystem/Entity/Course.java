package com.todo.studentcoursesystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "course",
        uniqueConstraints = @UniqueConstraint(columnNames = "course_code")
)
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_code", nullable = false)
    private String courseCode;

    @Column(name = "credits", nullable = false)
    private int credits;

    @Column(name = "duration_in_weeks", nullable = false)
    private Integer duration;

    @OneToMany(mappedBy = "course",cascade=CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<Enrollment> enrollments = new ArrayList<>();
}
