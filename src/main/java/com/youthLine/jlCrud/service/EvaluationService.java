package com.youthLine.jlCrud.service;

import com.youthLine.jlCrud.entity.Evaluation;

import java.util.List;

public interface EvaluationService {
    List<Evaluation> findAll();

    Evaluation findById(int theId);

    Evaluation save(Evaluation theEvaluation);

    void deleteById(int theId);
}
