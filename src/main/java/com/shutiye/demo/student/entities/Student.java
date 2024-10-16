package com.shutiye.demo.student.entities;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table(name = "stdinfo")

public class Student {
//            @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    Long studentid;
    @NotBlank
    String firstname;
    @NotBlank
    String lastname;
    @Email
    String email;
    int courseId;
    String courseName;
    String courseDescription;

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }




    public Student(String firstname, String lastname, String email, int courseId, String courseName, String courseDescription) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public Student (){}

    public Long getStdId() {
        return studentid;
    }

    public void setStdId(Long stdId) {
        this.studentid = stdId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(student, student.studentid) && Objects.equals(firstname, student.firstname) && Objects.equals(lastname, student.lastname) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentid, firstname, lastname, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }
}
