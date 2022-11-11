package com.survey.repository;
import com.survey.model.Question;
import com.survey.model.Survey_composition;
import com.survey.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Survey_compositionRepository extends  JpaRepository< Survey_composition, Long>{
    @Query("select s from Survey_composition s where s.id_survey = ?1")
    List<Survey_composition> findById_survey(Long id_survey);




    //List<Survey_composition> findById_survey(Long id_survey);

}
