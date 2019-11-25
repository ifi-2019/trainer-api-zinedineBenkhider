package com.eservices.ifi.tp.pokemon_type_api.service;

import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PokemonTypeService {
    PokemonType getPokemonType(int id);

    List<PokemonType> getAllPokemonTypes();
    List<PokemonType> getPokemonTypesWithTypes(String types);
    PokemonType getPokemonTypeWithName(String name);
}
