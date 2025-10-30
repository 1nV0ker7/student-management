package com.sm.studentservice.mapper;

import com.sm.studentservice.dto.StudentResponseDTO;
import com.sm.studentservice.model.Student;

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
}
