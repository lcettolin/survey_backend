package com.survey.model;

import com.survey.repository.Survey_compositionRepository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@IdClass(SurveyPK.class)
@Entity
@Table(name = "survey_composition")

public class Survey_composition {
    @Id
    @Column(name = "id_survey")
    private Long id_survey;

    @Id
    @Column(name = "id_question_answer")
    private Long id_question_answer;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_survey", nullable = false, insertable = false, updatable = false)
    private Survey_table survey;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_question_answer", nullable = false, insertable = false, updatable = false)
    private Question_answer question_answer;

    public Survey_composition(){};
    public Survey_composition(Long id_survey, Long id_question_answer) {
        this.id_survey = id_survey;
        this.id_question_answer = id_question_answer;
    }

    public long getId_survey() {
        return id_survey;
    }

    public void setId_survey(Long id_survey) {
        this.id_survey = id_survey;
    }

    public long getId_question_answer() {
        return id_question_answer;
    }

    public void setId_question_answer(Long id_question_answer) {
        this.id_question_answer = id_question_answer;
    }

    public Question_answer getQuestion_answer() {
        return question_answer;
    }
}

class SurveyPK implements Serializable {
    private Long id_survey;
    private Long id_question_answer;

    public SurveyPK() {
    }


    public SurveyPK(Long id_survey, Long id_question_answer) {
        this.id_survey = id_survey;
        this.id_question_answer = id_question_answer;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null||getClass() !=o.getClass()) return false;
        SurveyPK surveyPK = (SurveyPK) o;
        return id_survey.equals(surveyPK.id_survey) && id_question_answer.equals(surveyPK.id_question_answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_survey,id_question_answer);
    }
}


