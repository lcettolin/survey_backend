package com.survey.controller;

import com.survey.model.Question;
import com.survey.model.Submitted_survey;
import com.survey.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("survey/api")

public class QuestionController {

    @Autowired
    QuestionRepository repository;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            List<Question> questions = new ArrayList<Question>();

            repository.findAll().forEach(questions::add);

            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(
            value = "/question",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Question> createSubmitted_survey(@RequestBody Question q) {
        try {
            Question newQuestion = repository.save(new Question(q.getQuestion(),q.getCategoryId() ));
            return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
