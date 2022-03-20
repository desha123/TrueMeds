package com.example.truemeds.controllers;
import com.example.truemeds.service.TrueMedsService;
import com.example.truemeds.service.TrueMedsServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TrueMedsResourse {

    private static final Logger log = LogManager.getLogger(TrueMedsResourse.class);
    @Autowired
    private TrueMedsService treeservice = new TrueMedsServiceImpl();

    /**
     * GET  /final-output : trigger to save records from InputDetails entity without repeating characters
     */
    @GetMapping("/final-output")
    public void removeAdjacentSimilarCharacters() {
        log.info("REST request to save records in finalOutput table with no adjacent repeating characters");
        treeservice.removeAdjacentSimilarCharacters();
    }
}
