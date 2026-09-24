package com.example.demo.repository;
import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ICommitRepository extends JpaRepository<Commit, Long> {

    //Consulta4
    List<Commit> findByRepository_ParentRepo_IsTemplateTrueAndRepository_ParentRepo_NameAndMessageContainingIgnoreCaseAndLinesAddedGreaterThan(
            String templateName,
            String keyword,
            Integer linesAdded
    );

}