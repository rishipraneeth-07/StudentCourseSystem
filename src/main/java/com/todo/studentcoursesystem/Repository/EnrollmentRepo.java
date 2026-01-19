package com.todo.studentcoursesystem.Repository;

import com.todo.studentcoursesystem.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

    List<Enrollment> findAllByStudentId(Long studentId);

    List<Enrollment> findAllByCourseId(Long courseId);
}
