package com.survey.repository;

import com.survey.model.Question_answer;
import com.survey.model.Submitted_answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Submitted_answerRepository extends JpaRepository<Submitted_answer, Long> {
    Page<Submitted_answer> findAll(Pageable pageable);
}
