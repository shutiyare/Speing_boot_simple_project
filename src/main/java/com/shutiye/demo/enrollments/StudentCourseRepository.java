package com.shutiye.demo.enrollments;

import com.shutiye.demo.student.entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentCourseRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentCourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAllStudentsWithCourses() {
        String sql = "SELECT s.studentid, s.firstname, s.lastname, s.email, " +
                "c.courseId, c.courseName, c.courseDescription " +
                "FROM stdinfo s " +
                "JOIN enrollments e ON s.studentid = e.studentid " +
                "JOIN courses c ON e.courseId = c.courseId " +
                "ORDER BY s.lastname, s.firstname";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student dto = new Student();
            dto.setStdId(rs.getLong("studentid"));
            dto.setFirstname(rs.getString("firstname"));
            dto.setLastname(rs.getString("lastname"));
            dto.setEmail(rs.getString("email"));
            dto.setCourseId(rs.getInt("courseId"));
            dto.setCourseName(rs.getString("courseName"));
            dto.setCourseDescription(rs.getString("courseDescription"));
            return dto;
        });
    }

    public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        String sql = "SELECT * FROM stdinfo WHERE firstname =? AND lastname = ?";
        return jdbcTemplate.query(sql, new Object[]{firstName, lastName}, (rs, rowNum) -> {
            Student student = new Student();
            student.setStdId(rs.getLong("studentid"));
            student.setFirstname(rs.getString("firstname"));
            student.setLastname(rs.getString("lastname"));
            student.setEmail(rs.getString("email"));
//            student.setCourseId(rs.getInt("courseId"));
//            student.setCourseName(rs.getString("courseName"));
//            student.setCourseDescription(rs.getString("courseDescription"));
            System.out.println("student in query : " + student);
            return student;
        });
    }
}
