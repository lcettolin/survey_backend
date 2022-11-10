package com.survey.controller;

import com.survey.model.Submitted_answer;
import com.survey.model.Submitted_survey;
import com.survey.repository.Submitted_answerRepository;
import com.survey.repository.Submitted_surveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("survey/api")

public class Submitted_answerController {

    @Autowired
    Submitted_answerRepository repository;

    @PostMapping(
            value = "/submitted-answer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Submitted_answer> createSubmitted_answer(@RequestBody Submitted_answer survey) {
        try {
            Submitted_answer newSurvey = repository.save(new Submitted_answer(survey.getId_submitted_survey(), survey.getId_question_answer() ));
            return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
