package com.survey.controller;

import com.survey.model.Question;
import com.survey.model.Question_answer;
import com.survey.model.Submitted_survey;
import com.survey.model.Survey_composition;
import com.survey.repository.Question_answerRepository;
import com.survey.repository.Survey_compositionRepository;
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
public class Survey_compositionController {
    @Autowired
    Survey_compositionRepository repository;

    @GetMapping("/survey-composition/{id_survey}")
    public ResponseEntity<List<Survey_composition>> getSurvey_composition(@PathVariable("id_survey") Long id_survey) {
        try {
            List<Survey_composition> survComp = new ArrayList<Survey_composition>();
            repository.findById_survey(id_survey).forEach(survComp::add);
            if (survComp.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(survComp, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(
            value = "/survey-composition",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Survey_composition> createSubmitted_survey(@RequestBody Survey_composition survey_composition) {
        try {
            Survey_composition newSurveyComposition = repository.save(new Survey_composition(survey_composition.getId_survey(), survey_composition.getId_question_answer()));
            return new ResponseEntity<>(newSurveyComposition, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}