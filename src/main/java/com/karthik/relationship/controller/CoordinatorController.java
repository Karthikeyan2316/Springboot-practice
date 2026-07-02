package com.karthik.relationship.controller;

import com.karthik.relationship.dto.CoordinatorDto;
import com.karthik.relationship.model.Address;
import com.karthik.relationship.model.Coordinator;
import com.karthik.relationship.service.CoordinatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coordinator")
@CrossOrigin(origins = "*")
public class CoordinatorController {

    private final CoordinatorService coordinatorService;
    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }
    @PostMapping("/add")
    public ResponseEntity<Coordinator> createCoordinator(@RequestBody CoordinatorDto coordinatorDto) {
        return new ResponseEntity<>(coordinatorService.createCoordinator(coordinatorDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Coordinator>> getAllCoordinators() {
        return new ResponseEntity<>(coordinatorService.getAllCoordinators(),HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Coordinator> getCoordinatorById(@PathVariable long id) {
        return new ResponseEntity<>(coordinatorService.getCoordinatorById(id),HttpStatus.OK);
    }
}
