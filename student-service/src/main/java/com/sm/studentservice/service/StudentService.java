package com.sm.studentservice.service;

import com.sm.studentservice.dto.StudentRequestDTO;
import com.sm.studentservice.dto.StudentResponseDTO;
import com.sm.studentservice.exception.EmailAlreadyExistsException;
import com.sm.studentservice.exception.StudentNotFoundException;
import com.sm.studentservice.mapper.StudentMapper;
import com.sm.studentservice.model.Student;
import com.sm.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDTO> getStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(StudentMapper::toDto).toList();
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        if (studentRepository.existsByEmail(studentRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A student with this email already exists: " + studentRequestDTO.getEmail());
        }
        Student newStudent = studentRepository.save(StudentMapper.toModel(studentRequestDTO));

        return StudentMapper.toDto(newStudent);
    }

    public StudentResponseDTO updateStudent(UUID id, StudentRequestDTO studentRequestDTO) {

        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        if (studentRepository.existsByEmail(studentRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException("A student with this email already exists: " + studentRequestDTO.getEmail());
        }

        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setAddress(studentRequestDTO.getAddress());
        student.setDateOfBirth(LocalDate.parse(studentRequestDTO.getDateOfBirth()));

        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.toDto(updatedStudent);

    }

}
