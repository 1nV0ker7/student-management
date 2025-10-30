package com.sm.studentservice.service;

import com.sm.studentservice.dto.StudentResponseDTO;
import com.sm.studentservice.mapper.StudentMapper;
import com.sm.studentservice.model.Student;
import com.sm.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDTO> getStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(
                StudentMapper::toDto).toList();
    }

}
