package com.karthik.relationship.service;

import com.karthik.relationship.dto.CoordinatorDto;
import com.karthik.relationship.exception.StudentNotFound;
import com.karthik.relationship.model.Coordinator;
import com.karthik.relationship.repository.CoordinatorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CoordinatorService {
    private final CoordinatorRepository coordinatorRepository;
    public CoordinatorService(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @Transactional
    public Coordinator createCoordinator(CoordinatorDto coordinatorDto) {
        Coordinator coordinator = new Coordinator();
        coordinator.setName(coordinatorDto.getName());
        coordinator.setEmail(coordinatorDto.getEmail());

        return coordinatorRepository.save(coordinator);
    }

    public List<Coordinator> getAllCoordinators() {
        return coordinatorRepository.findAll();
    }

    public Coordinator getCoordinatorById(long id) {
        return coordinatorRepository.findById(id).orElseThrow(()->new StudentNotFound("Coordinator not found with id "+id));
    }
}
