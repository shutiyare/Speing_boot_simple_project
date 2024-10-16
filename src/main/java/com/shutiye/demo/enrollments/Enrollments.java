package com.shutiye.demo.enrollments;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "enrollments")
public class Enrollments {
    @Id
    private int enrollmentid;

}
