package com.todo.studentcoursesystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student_profile")
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "address")
    private String address;

    @Column(nullable = false,name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false,name = "gender")
    private String gender;


}
