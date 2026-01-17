package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Course;

public interface CourseService {
    public Course createCourse(Course course);
    public Course getCourse(Long courseId);
    public Course updateCourse(Course course, Long courseId);
    public void deleteCourse(Long courseId);
}
