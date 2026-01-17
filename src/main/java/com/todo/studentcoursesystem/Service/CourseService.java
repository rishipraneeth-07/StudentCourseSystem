package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Course;

public interface CourseService {
    Course createCourse(Course course);
    Course getCourse(Long courseId);
    Course updateCourse(Course course, Long courseId);
    void deleteCourse(Long courseId);
}
