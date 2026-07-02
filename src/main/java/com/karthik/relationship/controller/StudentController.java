package com.karthik.relationship.controller;

import com.karthik.relationship.dto.AddClubToStudentDto;
import com.karthik.relationship.dto.StudentDto;
import com.karthik.relationship.model.Student;
import com.karthik.relationship.model.StudentClub;
import com.karthik.relationship.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.updateStudent(id,studentDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.deleteStudentById(id),HttpStatus.OK);

    }

    @PutMapping("/coordinator")
    public ResponseEntity<Student> updateStudent(@RequestParam Long studentId,@RequestParam Long coordinatorId) {
        return new ResponseEntity<>(studentService.updateStudentWithCoordinator(studentId,coordinatorId),HttpStatus.OK);
    }

    @PutMapping("/club")
    public ResponseEntity<List<StudentClub>> updateStudentClub(@RequestBody AddClubToStudentDto addClubToStudentDto) {
        return new ResponseEntity<>(studentService.updateStudentClub(addClubToStudentDto),HttpStatus.OK);
    }

}
