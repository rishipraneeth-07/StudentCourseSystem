package com.todo.studentcoursesystem.Controller;

import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Entity.StudentProfile;
import com.todo.studentcoursesystem.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    // 2. Get Student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    // 3. Update Student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student updatedStudent = studentService.updateStudent(student, id);
        return ResponseEntity.ok(updatedStudent);
    }

    // 4. Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // 5. Attach Student Profile
    @PostMapping("/{id}/profile")
    public ResponseEntity<Student> attachStudentProfile(
            @PathVariable Long id,
            @RequestBody StudentProfile studentProfile) {

        Student student = studentService.attachStudentProfile(studentProfile, id);
        return ResponseEntity.ok(student);
    }
}
