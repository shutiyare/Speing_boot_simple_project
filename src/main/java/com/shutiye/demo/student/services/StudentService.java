package com.shutiye.demo.student.services;
import com.shutiye.demo.student.entities.Student;
import com.shutiye.demo.student.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student saveStudent(Student student){
        System.out.printf("in student Service -> saveStudent : %s \n", student);
        return studentRepository.save(student);
    }
//    Get Single Student
    public Student getStudent(Long studentid) {
        System.out.printf("in student Service -> getStudent : %s \n", studentid);
        return studentRepository.findById(studentid).orElse(null);
    }
//    Get All Students
    public List<Student> getAllStudents() {
        System.out.printf("in student Service -> getAllStudents " );
        return (List<Student> )studentRepository.findAll();
    }
//    Update Student By ID
    public Student updateStudent(Long studentid, Student updatedStudent) {
        if (!studentRepository.existsById(studentid)) {
            throw new IllegalArgumentException("Student with ID " + studentid + " does not exist.");
        }
        updatedStudent.setStdId(studentid); // Ensure the ID is set for the entity
        return studentRepository.save(updatedStudent);
    }

    // Method to delete a student by ID
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist.");
        }
        studentRepository.deleteById(id);
    }


}
