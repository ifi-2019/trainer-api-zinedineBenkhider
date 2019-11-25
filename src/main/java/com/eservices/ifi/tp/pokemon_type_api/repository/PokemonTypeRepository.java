package com.eservices.ifi.tp.pokemon_type_api.repository;

import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeRepository {
    PokemonType findPokemonTypeById(int id);
    PokemonType findPokemonTypeByName(String name);
    List<PokemonType> findAllPokemonType();
    List<PokemonType> findAllPokemonTypeWithTypes(String types);
}
