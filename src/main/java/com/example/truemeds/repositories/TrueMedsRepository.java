package com.example.truemeds.repositories;

import com.example.truemeds.entities.FinalOutput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TrueMedsRepository extends JpaRepository<FinalOutput, Long> {

    @Query("select input.inputString from InputDetails input")
    List<String> getInputStrings();
}