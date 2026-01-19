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

    private final EnrollmentRepo enrollmentRepo;
    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;

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
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        List<Enrollment> enrollments = enrollmentRepo.findAllByStudentId(studentId);
        return enrollments.stream()
                .map(Enrollment::getCourse)
                .toList();
    }

    @Override
    public List<Student> getAllStudentsOfCourse(Long courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        List<Enrollment> enrollments = enrollmentRepo.findAllByCourseId(courseId);
        return enrollments.stream()
                .map(Enrollment::getStudent)
                .toList();
    }

    @Override
    public void removeEnrollment(Long studentId, Long courseId) {
        Enrollment enrollment = enrollmentRepo
                .findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() ->
                        new RuntimeException("Enrollment not found for student "
                                + studentId + " and course " + courseId));

        enrollmentRepo.delete(enrollment);
    }
}