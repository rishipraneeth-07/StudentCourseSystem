package com.todo.studentcoursesystem.Controller;

import com.todo.studentcoursesystem.Entity.Course;
import com.todo.studentcoursesystem.Entity.Enrollment;
import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<Enrollment> enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        Enrollment enrollment =
                enrollmentService.enrollStudent(studentId, courseId);

        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<Course>> getAllCoursesOfStudent(
            @PathVariable Long studentId) {

        List<Course> courses =
                enrollmentService.getAllCoursesOfStudent(studentId);

        return ResponseEntity.ok(courses);
    }


    @GetMapping("/courses/{courseId}/students")
    public ResponseEntity<List<Student>> getAllStudentsOfCourse(
            @PathVariable Long courseId) {

        List<Student> students =
                enrollmentService.getAllStudentsOfCourse(courseId);

        return ResponseEntity.ok(students);
    }


    @DeleteMapping
    public ResponseEntity<Void> removeEnrollment(
            @RequestParam Long studentId,
            @RequestParam Long courseId) {

        enrollmentService.removeEnrollment(studentId, courseId);
        return ResponseEntity.noContent().build();
    }
}
