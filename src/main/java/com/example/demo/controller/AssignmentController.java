package com.example.demo.controller;
import com.example.demo.model.Assignment;
import com.example.demo.repository.IAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    @Autowired
    private final IAssignmentRepository assignmentRepository;

    @GetMapping
    public List<Assignment> findAllAssignments() {
        return assignmentRepository.findAll();
    }

    @GetMapping("/consulta5")
    public List<Assignment> consulta5() {
        return assignmentRepository
                .findDistinctByClassroom_Teacher_UsernameAndRepositories_PullRequests_Reviewer_UsernameAndRepositories_PullRequests_Status(
                        "krodriguez",
                        "jvalencia",
                        "MERGED"
                );
    }
}