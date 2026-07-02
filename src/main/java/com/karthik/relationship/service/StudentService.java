package com.karthik.relationship.service;


import com.karthik.relationship.dto.AddClubToStudentDto;
import com.karthik.relationship.dto.StudentDto;
import com.karthik.relationship.exception.StudentNotFound;
import com.karthik.relationship.model.Address;
import com.karthik.relationship.model.Coordinator;
import com.karthik.relationship.model.Student;
import com.karthik.relationship.model.StudentClub;
import com.karthik.relationship.repository.CoordinatorRepository;
import com.karthik.relationship.repository.StudentClubRepository;
import com.karthik.relationship.repository.StudentRepository;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CoordinatorRepository coordinatorRepository;
    private final StudentClubRepository studentClubRepository;

    public StudentService(StudentRepository studentRepository, CoordinatorRepository coordinatorRepository,StudentClubRepository studentClubRepository) {
        this.coordinatorRepository = coordinatorRepository;
        this.studentRepository = studentRepository;
        this.studentClubRepository = studentClubRepository;
    }

    @Transactional
    public Student addStudent(StudentDto studentDto) {

        Student student = new Student();
        Address address = new Address();
        address.setCity(studentDto.getAddress().getCity());
        address.setState(studentDto.getAddress().getState());
        address.setStreet(studentDto.getAddress().getStreet());
        address.setZip(studentDto.getAddress().getZip());
        student.setAddress(address);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        return studentRepository.save(student);

    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFound("Student not found with id " + id));
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student updateStudent(Long id, StudentDto studentDto) {
        Student updateStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFound("Student not found with id " + id));

        updateStudent.setFirstName(studentDto.getFirstName());
        updateStudent.setLastName(studentDto.getLastName());
        updateStudent.setEmail(studentDto.getEmail());
        updateStudent.getAddress().setCity(studentDto.getAddress().getCity());
        updateStudent.getAddress().setState(studentDto.getAddress().getState());
        updateStudent.getAddress().setStreet(studentDto.getAddress().getStreet());
        updateStudent.getAddress().setZip(studentDto.getAddress().getZip());


        return studentRepository.save(updateStudent);
    }

    @Transactional
    public String deleteStudentById(Long id) {
        Student deleteStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFound("Student not found with id " + id));
        studentRepository.delete(deleteStudent);
        return "Deleted student with id " + id;
    }

    @Transactional
    public Student updateStudentWithCoordinator(Long studentId, Long coordinatorId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFound("Student not found with id " + studentId));
        Coordinator coordinator = coordinatorRepository.findById(coordinatorId).orElseThrow(() -> new StudentNotFound("Coordinator not found with id " + coordinatorId));
        student.setCoordinator(coordinator);
        return studentRepository.save(student);
    }

    @Transactional
    public List<StudentClub> updateStudentClub(AddClubToStudentDto addClubToStudentDto) {
        Student student = studentRepository.findById(addClubToStudentDto.getStudentId()).orElseThrow(() -> new StudentNotFound("Student not found with id " + addClubToStudentDto.getStudentId()));
        List<StudentClub>clubs=addClubToStudentDto.getClubIds().stream()
                .map(i->studentClubRepository.findById((long)i).orElseThrow(()->new StudentNotFound("Club not found with id " + i)))
                .collect(Collectors.toList());
        student.setStudentClubs(clubs);
        studentRepository.save(student);
        return clubs;
    }
}
