package com.ifi.trainer_api.controller;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping(value="/")
    public Iterable<Trainer> getAllTrainers(){
        return trainerService.listPokemonsTrainer();
    }

    @PutMapping(value = "/updatePassword",consumes = "application/json")
    void updatePassword(@RequestBody HttpEntity<String[]> NameAndPassword){
        Trainer trainer=trainerService.getTrainer(NameAndPassword.getBody()[0]);
        trainer.setPassword(NameAndPassword.getBody()[1]);
        trainerService.updateTrainer(trainer);
    }

    @GetMapping(value="/{name}")
    Trainer getTrainer(@PathVariable String name){
    return trainerService.getTrainer(name);
    }

    @PostMapping(value = "/",consumes = "application/json")
    Trainer addTrainer(@RequestBody Trainer trainer){
      return trainerService.createTrainer(trainer);
    }

    @DeleteMapping("/{name}")
    void deleteTrainer(@PathVariable String name){
        trainerService.deleteTrainer(name);
    }



}
