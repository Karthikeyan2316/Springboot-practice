package com.karthik.relationship.repository;

import com.karthik.relationship.model.LibraryBooks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryBookRepository extends JpaRepository<LibraryBooks,Long> {


    public Page<LibraryBooks> findAll(Pageable pageable);
}
