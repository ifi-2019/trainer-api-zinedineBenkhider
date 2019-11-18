package com.ifi.trainer_api;

import com.ifi.trainer_api.bo.Pokemon;
import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class TrainerApi {
    @Bean
    @Autowired
    public CommandLineRunner demo(TrainerRepository repository) {
        return (args) -> {
            Trainer ash = new Trainer("Ash");
            Pokemon pikachu = new Pokemon(25, 18);
            List<Pokemon> listPokemonOfAsh=new ArrayList<>();
            listPokemonOfAsh.add(pikachu);
            ash.setTeam(listPokemonOfAsh);

            Trainer misty = new Trainer("Misty");
            Pokemon staryu = new Pokemon(120, 18);
            Pokemon starmie = new Pokemon(121, 21);
            List<Pokemon> listpokemeonOfMisty=new ArrayList<>();
            listpokemeonOfMisty.add(staryu);
            listpokemeonOfMisty.add(starmie);
            misty.setTeam(listpokemeonOfMisty);

            // save a couple of trainers
            repository.save(ash);
            repository.save(misty);
        };
    }
}
