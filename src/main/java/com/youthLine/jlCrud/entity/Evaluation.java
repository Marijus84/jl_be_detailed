package com.youthLine.jlCrud.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "current_state_ids")
    private String currentState;

    @Column(name = "crisis_test_result")
    private int crisisTestResult;

    @PrePersist
    protected void onCreate(){
        timestamp = LocalDateTime.now();
    }

    public Evaluation(){
    }

    public Evaluation(LocalDateTime timestamp, String currentState, int crisisTestResult) {
        this.timestamp = timestamp;
        this.currentState = currentState;
        this.crisisTestResult = crisisTestResult;
    }

    public int getCrisisTestResult() {
        return crisisTestResult;
    }

    public void setCrisisTestResult(int crisisTestResult) {
        this.crisisTestResult = crisisTestResult;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", currentState='" + currentState + '\'' +
                ", crisisTestResult=" + crisisTestResult +
                '}';
    }
}
