package com.youthLine.jlCrud.rest;

import com.youthLine.jlCrud.entity.Evaluation;
import com.youthLine.jlCrud.service.EvaluationService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EvaluationController {

    private EvaluationService evaluationService;

    public EvaluationController(EvaluationService theEvaluationService){
        evaluationService = theEvaluationService;
    }

    @GetMapping("/evals")
    public List<Evaluation> findAll() {
        return evaluationService.findAll();
    }

    @GetMapping("/evals/{evalId}")
    public Evaluation findById(@PathVariable int evalId){
        Evaluation theEvaluation = evaluationService.findById(evalId);

        if (theEvaluation == null){
            throw new RuntimeException("Evaluation not found: " + evalId);
        }

        return theEvaluation;
    }

    @PostMapping("/evals")
    public Evaluation addEvaluation(@RequestBody Evaluation theEvaluation){

        return evaluationService.save(theEvaluation);
    }

    @PutMapping("/evals")
    public Evaluation updateEvaluation(@RequestBody Evaluation theEvaluation){
        Evaluation tempEvaluation = evaluationService.findById(theEvaluation.getId());
        if(tempEvaluation == null){
            throw new RuntimeException("Evaluation not found" + theEvaluation.getId());
        }

        theEvaluation.setTimestamp(LocalDateTime.now());
        return evaluationService.save(theEvaluation);
    }

    @DeleteMapping("evals/{evalId}")
    public void deleteEvaluation(@PathVariable int evalId){
        Evaluation tempEvaluation = evaluationService.findById(evalId);

        if(tempEvaluation == null){
            throw new RuntimeException("Evaluation not found" + evalId);
        }

        evaluationService.deleteById(evalId);
    }

}
