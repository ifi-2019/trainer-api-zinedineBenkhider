package com.ifi.trainer_api.service;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainerServiceImpl implements TrainerService{
    private RestTemplate restTemplate;
    private String pokemonTrainerServiceUrl;
    @Autowired
    TrainerRepository trainerRepository;
    public TrainerServiceImpl(TrainerRepository trainerRepo) {
        trainerRepository=trainerRepo;
    }



    public Iterable<Trainer> listPokemonsTrainer() {
       return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return trainerRepository.findById(name).get();
    }

    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public void deleteTrainer(String name){
        trainerRepository.deleteById(name);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }
}
