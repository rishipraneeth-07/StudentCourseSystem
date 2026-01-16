package com.todo.studentcoursesystem.Repository;

import com.todo.studentcoursesystem.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
}
