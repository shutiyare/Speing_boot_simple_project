package com.shutiye.demo.courses;

import jakarta.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "courses")
public class Courses {
    @Id
    private int courseid;
    private String coursename;
    private String coursedescription;
    private LocalDateTime createdat;
    private LocalDateTime updatedat;


    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public Courses(){}
    public Courses(String coursename, String coursedescription) {
        this.coursename = coursename;
        this.coursedescription = coursedescription;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursedescription() {
        return coursedescription;
    }

    public void setCoursedescription(String coursedescription) {
        this.coursedescription = coursedescription;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", coursedescription='" + coursedescription + '\'' +
                '}';
    }
}
