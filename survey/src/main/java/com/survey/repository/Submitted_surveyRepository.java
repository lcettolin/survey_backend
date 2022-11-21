package com.survey.repository;

import com.survey.model.Question;
import com.survey.model.Submitted_survey;
import com.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Submitted_surveyRepository extends JpaRepository<Submitted_survey, Long> {

}
