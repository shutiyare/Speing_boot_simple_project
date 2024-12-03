package com.shutiye.demo.enrollments;

import com.shutiye.demo.enrolledStudents.EnrolledStudents;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollments,Integer> {
}
