package com.eservices.ifi.tp.pokemon_type_api.service;

import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.eservices.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import com.eservices.ifi.tp.pokemon_type_api.repository.PokemonTypeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{
    private PokemonTypeRepository pokemonTypeRepository;
    @Autowired
    public PokemonTypeServiceImpl(PokemonTypeRepositoryImpl pokemonTypeRepository){
        this.pokemonTypeRepository=pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
            return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
    return this.pokemonTypeRepository.findAllPokemonType();
    }

    @Override
    public List<PokemonType> getPokemonTypesWithTypes(String types) {
        return this.pokemonTypeRepository.findAllPokemonTypeWithTypes(types);
    }

    @Override
    public PokemonType getPokemonTypeWithName(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }
}
