package com.karthik.relationship.controller;

import com.karthik.relationship.model.LibraryBooks;
import com.karthik.relationship.repository.LibraryBookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("*")
@RequestMapping("api/library")
public class LibraryBookController {

    private final LibraryBookRepository libraryBookRepository;
    public LibraryBookController(LibraryBookRepository libraryBookRepository) {
        this.libraryBookRepository = libraryBookRepository;
    }
    @GetMapping("books/all")
    public Page<LibraryBooks> findAll() {
        Random random = new Random();

        int number = random.nextInt(5) + 1;
        return libraryBookRepository.findAll( PageRequest.of(number, 10, Sort.by("id").descending()));
    }
}
