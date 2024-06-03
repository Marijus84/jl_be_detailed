package com.youthLine.jlCrud.service;

import com.youthLine.jlCrud.dao.EvaluationDAO;
import com.youthLine.jlCrud.entity.Evaluation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    private EvaluationDAO evaluationDAO;

    public EvaluationServiceImpl(EvaluationDAO theEvaluationDAO) {
        evaluationDAO = theEvaluationDAO;
    }

    @Override
    public List<Evaluation> findAll() {
        return evaluationDAO.findAll();
    }

    @Override
    public Evaluation findById(int theId) {
        return evaluationDAO.findById(theId);
    }

    @Transactional
    @Override
    public Evaluation save(Evaluation theEvaluation) {
        return evaluationDAO.save(theEvaluation);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        evaluationDAO.deleteById(theId);
    }
}
