package com.karthik.relationship.service;

import com.karthik.relationship.dto.StudentClubDto;
import com.karthik.relationship.exception.StudentNotFound;
import com.karthik.relationship.model.Student;
import com.karthik.relationship.model.StudentClub;
import com.karthik.relationship.repository.StudentClubRepository;
import com.karthik.relationship.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentClubService {

    private final StudentClubRepository studentClubRepository;
    private final StudentRepository studentRepository;

    public StudentClubService(StudentClubRepository studentClubRepository,StudentRepository studentRepository) {
        this.studentClubRepository = studentClubRepository;
        this.studentRepository = studentRepository;
    }


    public List<StudentClub> getAllClubs() {
        return studentClubRepository.findAll();
    }

    @Transactional
    public StudentClub updateHeadOfClub(Long studentId,Long clubId) {

        Student headOfClub = studentRepository.findById(studentId).orElseThrow(()->new StudentNotFound("Student not found with id "+studentId));
        StudentClub studentClub = studentClubRepository.findById(clubId).orElseThrow(()->new StudentNotFound("Club not found with id "+clubId));
        studentClub.setHeadOfClub(headOfClub);

        return studentClubRepository.save(studentClub);

    }

    @Transactional
    public StudentClub addClub(StudentClubDto studentClubDto) {
        StudentClub studentClub = new StudentClub();
        studentClub.setClubName(studentClubDto.getClubName());
        return studentClubRepository.save(studentClub);
    }
}
