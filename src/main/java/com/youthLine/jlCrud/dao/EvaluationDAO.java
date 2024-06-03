package com.youthLine.jlCrud.dao;

import com.youthLine.jlCrud.entity.Evaluation;

import java.util.List;

public interface EvaluationDAO {

    List<Evaluation> findAll();

    Evaluation findById(int theId);

    Evaluation save(Evaluation theEvaluation);

    void deleteById(int theId);
}
