package com.shutiye.demo.enrolledStudents;

import com.shutiye.demo.student.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrolledStudentsService {
    private final EnrolledStudentsRepository enrolledStudentsRepository;

    public EnrolledStudentsService(EnrolledStudentsRepository enrolledStudentsRepository) {
        this.enrolledStudentsRepository = enrolledStudentsRepository;
    }

    public Iterable<EnrolledStudents> getAllEnrolledStudents() {
        return  enrolledStudentsRepository.findAllFromView();
    }
}
