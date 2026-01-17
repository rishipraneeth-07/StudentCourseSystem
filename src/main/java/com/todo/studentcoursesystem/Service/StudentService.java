package com.todo.studentcoursesystem.Service;


import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Entity.StudentProfile;

public interface StudentService {
    public Student createStudent(Student student);
    public Student getStudent(Long studentId);
    public Student updateStudent(Student student, Long studentId);
    public void deleteStudent(Long studentId);
    public Student attachStudentProfile(StudentProfile studentProfile, Long studentId);
}
