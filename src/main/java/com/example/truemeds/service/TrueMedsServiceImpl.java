package com.example.truemeds.service;

import com.example.truemeds.controllers.TrueMedsResourse;
import com.example.truemeds.entities.FinalOutput;
import com.example.truemeds.repositories.TrueMedsRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Stack;

/**
 * Service Implementation for managing TrueMedsService
 */
@Service
@Transactional
public class TrueMedsServiceImpl implements TrueMedsService {

    private static final Logger log = LogManager.getLogger(TrueMedsServiceImpl.class);

    @Autowired
    private TrueMedsRepository trueMedsRepository;

    @Override
    public void removeAdjacentSimilarCharacters() {
        List<String> inputList = trueMedsRepository.getInputStrings();
        inputList.forEach(e -> {
            FinalOutput opt = removeDuplicatesAndSave(e);
            log.info("Request to save FinalOutput : {}", opt);
            trueMedsRepository.save(opt);
        });
    }

    /**
     * This method removes adjacent similar characters from input string and sets in object
     *
     * @param input the input string
     * @return FinalOutput Object
     */
    public FinalOutput removeDuplicatesAndSave(String input) {
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        int steps = 0;
        input = input.replaceAll("\\s", "");
        while (i < input.length()) {
            if (stack.isEmpty() ||
                    input.charAt(i) != stack.peek()) {
                stack.add(input.charAt(i));
                i++;
            } else {
                stack.pop();
                steps++;
                i++;
            }
        }
        String newString = "";
        while (!stack.isEmpty()) {
            newString = stack.peek() + newString;
            stack.pop();
        }
        FinalOutput finalOutput = new FinalOutput();
        finalOutput.setFinalOutput(newString);
        finalOutput.setCount(steps);
        return finalOutput;
    }
}