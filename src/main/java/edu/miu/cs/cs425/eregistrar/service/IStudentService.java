package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
        List<Student> getStudents();
        Student saveStudent(Student student);
        Optional<Student> findStudentById(long studentId);
        void deleteStudent(Student student);

}
