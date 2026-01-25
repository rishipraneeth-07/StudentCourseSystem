package com.todo.studentcoursesystem.Controller;

import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Service.CourseService;
import com.todo.studentcoursesystem.Service.EnrollmentService;
import com.todo.studentcoursesystem.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {


    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final StudentService studentService;


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

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student
                                                 , @PathVariable Long id
                                                 ,@RequestHeader(value = "X-Admin",required = false)String xAdmin){
        if (!"true".equals(xAdmin)) {
            throw new RuntimeException("Access denied: Admin only");
        }
        Student updateStudent=studentService.updateStudent(student, id);
        return ResponseEntity.ok(updateStudent);

    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id,
                               @RequestHeader(value = "X-Admin",required = false) String xAdmin){
        if (!"true".equals(xAdmin)) {
            throw new RuntimeException("Access denied: Admin only");
        }
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();

    }
}
