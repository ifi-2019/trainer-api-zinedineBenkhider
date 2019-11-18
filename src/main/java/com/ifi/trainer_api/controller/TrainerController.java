package com.ifi.trainer_api.controller;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@RestController
@RequestMapping(value = "/trainers")
public class TrainerController {
    @Autowired
    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping(value="/")
    Iterable<Trainer> getAllTrainers(){
        return trainerService.getAllTrainers();


    }
    @GetMapping(value="/{name}")
    Trainer getTrainer(@PathVariable String name){
    return trainerService.getTrainer(name);
    }

}
