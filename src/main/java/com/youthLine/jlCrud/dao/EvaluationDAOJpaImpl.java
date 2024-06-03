package com.youthLine.jlCrud.dao;

import com.youthLine.jlCrud.entity.Evaluation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EvaluationDAOJpaImpl implements EvaluationDAO {

    private static final Logger log = LoggerFactory.getLogger(EvaluationDAOJpaImpl.class);
    private EntityManager entityManager;

    @Autowired
    public EvaluationDAOJpaImpl (EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Evaluation> findAll() {

        TypedQuery<Evaluation> theQuery = entityManager.createQuery("from Evaluation", Evaluation.class);

        return theQuery.getResultList();
    }

    @Override
    public Evaluation findById(int theId) {
        return entityManager.find(Evaluation.class, theId);
    }

    @Override
    public Evaluation save(Evaluation theEvaluation) {
        return entityManager.merge(theEvaluation);
    }

    @Override
    public void deleteById(int theId) {
        Evaluation theEvaluation = entityManager.find(Evaluation.class, theId);
        entityManager.remove(theEvaluation);
    }
}
