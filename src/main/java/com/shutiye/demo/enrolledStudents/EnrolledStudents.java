package com.shutiye.demo.enrolledStudents;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Table;
@Immutable
@Table(name = "StudentwithCourses",schema = "StudentwithCourses")
public record EnrolledStudents(
        @Id
        Long studentid,
        String studentname,
        String email,
        int courseid,
        String courseName,
        String courseDescription
) {
}
