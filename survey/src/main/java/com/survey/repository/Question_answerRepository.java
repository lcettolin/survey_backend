package com.survey.repository;

import com.survey.model.Answer;
import com.survey.model.Question_answer;
import com.survey.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Question_answerRepository extends JpaRepository<Question_answer, Long> {
    Page<Question_answer> findAll(Pageable pageable);
}
