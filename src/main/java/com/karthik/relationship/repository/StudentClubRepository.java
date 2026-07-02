package com.karthik.relationship.repository;

import com.karthik.relationship.model.StudentClub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClubRepository extends JpaRepository<StudentClub,Long> {
}
