package com.karthik.relationship.repository;

import com.karthik.relationship.model.StudentClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentClubRepository extends JpaRepository<StudentClub,Long> {

    List<StudentClub> findStudentClubByClubIdIsIn(List<Integer> ids);
}
