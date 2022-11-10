package com.survey.repository;

import com.survey.model.Survey_table;
import com.survey.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Survey_tableRepository extends JpaRepository<Survey_table, Long> {
    Optional<Survey_table> findById(long id_survey);

    Page<Survey_table> findAll(Pageable pageable);

}
