package com.example.demo.controller;
import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

    @Autowired
    private final IPullRequestRepository pullRequestRepository;

    @GetMapping
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    @GetMapping("/consulta1")
    public List<PullRequest> consulta1() {return pullRequestRepository.findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(
                        "Computacion en Internet II - Grupo 1",
                        "OPEN"
                );
    }

    @GetMapping("/consulta3")
    public List<PullRequest> consulta3() {
        return pullRequestRepository
                .findByReviewer_RoleAndAuthor_UsernameAndRepository_Assignment_Classroom_Semester(
                        "TA",
                        "cjimenez",
                        "2026-02"
                );
    }
}