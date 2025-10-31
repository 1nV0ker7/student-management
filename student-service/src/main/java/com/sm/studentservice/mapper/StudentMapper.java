package com.sm.studentservice.mapper;

import com.sm.studentservice.dto.StudentRequestDTO;
import com.sm.studentservice.dto.StudentResponseDTO;
import com.sm.studentservice.model.Student;

import java.time.LocalDate;

public class StudentMapper {
    public static StudentResponseDTO toDto(Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setId(student.getId().toString());
        studentResponseDTO.setName(student.getName());
        studentResponseDTO.setEmail(student.getEmail());
        studentResponseDTO.setAddress(student.getAddress());
        studentResponseDTO.setDateOfBirth(student.getDateOfBirth().toString());
        return studentResponseDTO;
    }

    public static Student toModel(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setAddress(studentRequestDTO.getAddress());
        student.setDateOfBirth(LocalDate.parse(studentRequestDTO.getDateOfBirth()));
        student.setAdmissionDate(LocalDate.parse(studentRequestDTO.getAdmissionDate()));
        return student;
    }
}
