package com.todo.studentcoursesystem.Service;

import com.todo.studentcoursesystem.Entity.Student;
import com.todo.studentcoursesystem.Entity.StudentProfile;
import com.todo.studentcoursesystem.Repository.StudentProfileRepo;
import com.todo.studentcoursesystem.Repository.StudentRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class StudentServiceImpl implements StudentService {
    private StudentProfile studentProfile;
    private StudentProfileRepo studentProfileRepo;
    private Student student;
    private StudentRepo studentRepo;


    @Override
    public Student createStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudent(Long studentId) {
        return null;
    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        return null;
    }

    @Override
    public void deleteStudent(Long studentId) {

    }

    @Override
    public Student attachStudentProfile(StudentProfile studentProfile, Long studentId) {
        return null;
    }
}
