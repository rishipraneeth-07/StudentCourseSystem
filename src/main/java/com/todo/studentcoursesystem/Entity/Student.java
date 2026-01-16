package com.todo.studentcoursesystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false,name = "full_name")
    private String fullName;


    @Column(unique = true, nullable = false)
    private String email;


    @Column(unique = true, nullable = false,name = "roll_number")
    private String rollNumber;

    @Column(nullable = false,name = "created_on")
    private LocalDateTime createdOn;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private StudentProfile studentProfile;


}
