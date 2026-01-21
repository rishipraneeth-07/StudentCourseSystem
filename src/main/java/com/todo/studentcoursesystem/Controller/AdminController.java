package com.todo.studentcoursesystem.Controller;

import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Service.CourseService;
import com.todo.studentcoursesystem.Service.EnrollmentService;
import com.todo.studentcoursesystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {


    private CourseService courseService;
    private EnrollmentService enrollmentService;
    private StudentService studentService;


    public AdminController(CourseService courseService, EnrollmentService enrollmentService, StudentService studentService) {
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student
                                                 ,@RequestHeader(value = "X-Admin",required = false) String xAdmin){
        if (!"true".equals(xAdmin)) {
            throw new RuntimeException("Access denied: Admin only");
        }
        Student createStudent=studentService.createStudent(student);
        return ResponseEntity.ok(createStudent);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id
                                              ,@RequestHeader(value = "X-Admin",required = false) String xAdmin){
        if (!"true".equals(xAdmin)) {
            throw new RuntimeException("Access denied: Admin only");
        }
        Student student=studentService.getStudent(id);
        return ResponseEntity.ok(student);

    }
}
