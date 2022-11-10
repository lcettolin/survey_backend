package com.survey.model;

import javax.persistence.*;
import java.io.Serializable;

@IdClass(UserPK.class)
@Entity
@Table(name = "submitted_answer")

public class Submitted_answer {

    @Id
    @Column(name = "id_submitted_survey")
    private long id_submitted_survey;

    @Id
    @Column(name = "id_question_answer")
    private long id_question_answer;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_submitted_survey", nullable = false, insertable = false, updatable = false)
    private Submitted_survey submitted_survey;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_question_answer", nullable = false, insertable = false, updatable = false)
    private Question_answer question_answer;


    public Submitted_answer(){}

    public Submitted_answer(long id_submitted_survey, long id_question_answer) {
        this.id_submitted_survey = id_submitted_survey;
        this.id_question_answer = id_question_answer;
    }

    public long getId_submitted_survey() {
        return id_submitted_survey;
    }

    public void setId_submitted_survey(long id_submitted_survey) {
        this.id_submitted_survey = id_submitted_survey;
    }

    public long getId_question_answer() {
        return id_question_answer;
    }

    public void setId_question_answer(long id_question_answer) {
        this.id_question_answer = id_question_answer;
    }

}

class UserPK implements Serializable {
    private long id_submitted_survey;
    private long id_question_answer;

    public UserPK() {
    }

    public UserPK(long id_submitted_survey, long id_question_answer) {
        this.id_submitted_survey = id_submitted_survey;
        this.id_question_answer = id_question_answer;
    }
}
