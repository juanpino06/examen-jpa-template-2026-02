package com.example.demo.controller;
import com.example.demo.model.Commit;
import com.example.demo.repository.ICommitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/commits")
@RequiredArgsConstructor
public class CommitController {

    @Autowired
    private final ICommitRepository commitRepository;

    @GetMapping
    public List<Commit> findAllCommits() {
        return commitRepository.findAll();
    }

    @GetMapping("/consulta4")
    public List<Commit> consulta4() {
        return commitRepository
                .findByRepository_ParentRepo_IsTemplateTrueAndRepository_ParentRepo_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(
                        "template-jpa-exam",
                        "fix",
                        50
                );
    }

}