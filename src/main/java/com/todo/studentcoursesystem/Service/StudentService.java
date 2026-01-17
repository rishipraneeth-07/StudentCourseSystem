package com.todo.studentcoursesystem.Service;


import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Entity.StudentProfile;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudent(Long studentId);
    Student updateStudent(Student student, Long studentId);
    void deleteStudent(Long studentId);
    Student attachStudentProfile(StudentProfile studentProfile, Long studentId);
}
