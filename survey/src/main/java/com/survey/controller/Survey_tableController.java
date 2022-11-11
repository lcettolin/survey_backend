package com.survey.controller;


import com.survey.model.Survey_composition;
import com.survey.model.Survey_table;
import com.survey.model.User;
import com.survey.repository.Survey_tableRepository;
import com.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("survey/api")

public class Survey_tableController {

    @Autowired
    Survey_tableRepository repository;

    @GetMapping("/surveys")
    public ResponseEntity<List<Survey_table>> getAllSurveys() {
        try {
            List<Survey_table> surveys = new ArrayList<>();

            surveys.addAll(repository.findAll());

            if (surveys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(surveys, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/survey",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Survey_table> createSubmitted_survey(@RequestBody Survey_table survey) {
        try {
            Survey_table newSurvey = repository.save(new Survey_table(survey.getId_mail(), survey.getId_category(), survey.getName(), survey.getDescription(), survey.getPublish_date(), survey.getEnding_date()));
            return new ResponseEntity<>(newSurvey, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
