package com.survey.controller;


import com.survey.model.Submitted_survey;
import com.survey.model.User;
import com.survey.repository.Submitted_surveyRepository;
import com.survey.repository.Survey_tableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("survey/api")

public class Submitted_surveyController {
    @Autowired
    Submitted_surveyRepository repository;

    @PostMapping(
            value = "/submitted-survey",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Submitted_survey> createSubmitted_survey(@RequestBody Submitted_survey survey) {
        try {
            Submitted_survey newSurvey = repository.save(new Submitted_survey(survey.getId_survey(), survey.getId_mail() ));
            return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
