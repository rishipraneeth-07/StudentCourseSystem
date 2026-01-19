package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Course;
import com.todo.studentcoursesystem.Repository.CourseRepo;
import com.todo.studentcoursesystem.Repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepo.findById(courseId).orElseThrow(()->new RuntimeException("course not found"));
    }

    @Override
    public Course updateCourse(Course course, Long courseId) {
        Course existingCourse = courseRepo.findById(courseId)
                .orElseThrow(()->new RuntimeException("course not found"));
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setCredits(course.getCredits());
        existingCourse.setDuration(course.getDuration());
        return courseRepo.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(()->new RuntimeException("course not found"));
        courseRepo.delete(course);

    }
}
