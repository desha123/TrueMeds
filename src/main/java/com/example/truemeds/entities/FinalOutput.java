package com.example.truemeds.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "desha_nayak_final_java_output")
public class FinalOutput {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String finalOutput;

    private int count;

    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String getFinalOutput() {
        return finalOutput;
    }

    public void setFinalOutput(String finalOutput) {
        this.finalOutput = finalOutput;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = "DeshaNayak created at: " + new Date();
    }

    @Override
    public String toString() {
        return "FinalOutput{" +
                "id=" + id +
                ", finalOutput='" + finalOutput + '\'' +
                ", count=" + count +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
