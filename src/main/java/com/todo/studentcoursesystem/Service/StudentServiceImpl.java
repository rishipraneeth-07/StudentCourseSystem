package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Entity.StudentProfile;
import com.todo.studentcoursesystem.Repository.StudentProfileRepo;
import com.todo.studentcoursesystem.Repository.StudentRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentProfileRepo studentProfileRepo;

    public StudentServiceImpl(StudentRepo studentRepo,
                              StudentProfileRepo studentProfileRepo) {
        this.studentRepo = studentRepo;
        this.studentProfileRepo = studentProfileRepo;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        Student existingStudent = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        existingStudent.setFullName(student.getFullName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setRollNumber(student.getRollNumber());

        return studentRepo.save(existingStudent);

    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        studentRepo.delete(student);

    }

    @Override
    public Student attachStudentProfile(StudentProfile studentProfile, Long studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        if (student.getStudentProfile() != null) {
            throw new RuntimeException("Student already has a profile");
        }
        studentProfile.setStudent(student);
        student.setStudentProfile(studentProfile);
        return studentRepo.save(student);
    }
}
