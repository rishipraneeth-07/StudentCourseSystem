package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Course;
import com.todo.studentcoursesystem.Entity.Enrollment;
import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Repository.CourseRepo;
import com.todo.studentcoursesystem.Repository.EnrollmentRepo;
import com.todo.studentcoursesystem.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private EnrollmentRepo enrollmentRepo;
    private CourseRepo courseRepo;
    private StudentRepo studentRepo;

    public EnrollmentServiceImpl(EnrollmentRepo enrollmentRepo, CourseRepo courseRepo, StudentRepo studentRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }


    @Override
    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        boolean alreadyEnrolled =
                enrollmentRepo.existsByStudentIdAndCourseId(studentId, courseId);

        if (alreadyEnrolled) {
            throw new RuntimeException("Student is already enrolled in this course");
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus("ACTIVE");
        enrollmentRepo.save(enrollment);
        return enrollment;
    }

    @Override
    public List<Course> getAllCoursesOfStudent(Long studentId) {
        return List.of();
    }

    @Override
    public List<Student> getAllStudentsOfCourse(Long courseId) {
        return List.of();
    }

    @Override
    public void removeEnrollment(Long studentId, Long courseId) {

    }
}
