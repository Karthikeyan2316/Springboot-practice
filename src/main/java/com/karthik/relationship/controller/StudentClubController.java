package com.karthik.relationship.controller;

import com.karthik.relationship.dto.StudentClubDto;
import com.karthik.relationship.model.Student;
import com.karthik.relationship.model.StudentClub;
import com.karthik.relationship.service.StudentClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/club")
public class StudentClubController {

    private final StudentClubService studentClubService;
    public StudentClubController(StudentClubService studentClubService) {
        this.studentClubService = studentClubService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentClub>> getAllClubs(){
        return new ResponseEntity<>(studentClubService.getAllClubs(), HttpStatus.OK);
    }

    @PutMapping("/headOfClub")
    public ResponseEntity<StudentClub> updateHeadOfClub(@RequestParam Long studentId,@RequestParam Long clubId){
        return new ResponseEntity<>(studentClubService.updateHeadOfClub(studentId,clubId),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<StudentClub> addClub(@RequestBody StudentClubDto studentClubDto){
        return new ResponseEntity<>(studentClubService.addClub(studentClubDto),HttpStatus.CREATED);
    }
}
