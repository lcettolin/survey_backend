package com.survey.controller;

import com.survey.model.Question;
import com.survey.model.Question_answer;
import com.survey.repository.QuestionRepository;
import com.survey.repository.Question_answerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
