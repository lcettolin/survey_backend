package com.survey.controller;

import com.survey.model.Question;
import com.survey.model.Question_answer;
import com.survey.model.Submitted_survey;
import com.survey.repository.QuestionRepository;
import com.survey.repository.Question_answerRepository;
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

public class Question_answerController {
    @Autowired
    Question_answerRepository repository;

    @GetMapping("/question-answer")
    public ResponseEntity<List<Question_answer>> getAllQuestion_answer() {
        try {
            List<Question_answer> questions = new ArrayList<Question_answer>();

            questions.addAll(repository.findAll());

            if (questions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(
            value = "/question-answer",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Question_answer> createSubmitted_survey(@RequestBody Question_answer qna) {
        try {
            Question_answer newQna = repository.save(new Question_answer(qna.getId_question(), qna.getId_answer() ));
            return new ResponseEntity<>(newQna, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
