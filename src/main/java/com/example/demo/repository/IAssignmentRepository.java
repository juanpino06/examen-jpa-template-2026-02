package com.example.demo.repository;
import com.example.demo.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {

    //Consulta5
    List<Assignment> findDistinctByClassroom_Teacher_UsernameAndRepositories_PullRequests_Reviewer_UsernameAndRepositories_PullRequests_Status(
            String teacherUsername,
            String reviewerUsername,
            String status
    );
}
