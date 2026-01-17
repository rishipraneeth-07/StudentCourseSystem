package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Course;
import com.todo.studentcoursesystem.Entity.Enrollment;
import com.todo.studentcoursesystem.Entity.Student;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(Long studentId, Long courseId);
    List<Course> getAllCoursesOfStudent(Long studentId);
    List<Student> getAllStudentsOfCourse(Long courseId);
    void removeEnrollment(Long studentId, Long courseId);
}
