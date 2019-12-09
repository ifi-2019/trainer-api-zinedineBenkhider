package com.ifi.trainer_api.service;

import com.ifi.trainer_api.bo.Trainer;

public interface TrainerService {
    Iterable<Trainer> listPokemonsTrainer();
    Trainer getTrainer(String name);
    Trainer createTrainer(Trainer trainer);
    void deleteTrainer(String name);
    void updateTrainer(Trainer trainer);
}


