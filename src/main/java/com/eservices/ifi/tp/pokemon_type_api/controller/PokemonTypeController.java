package com.eservices.ifi.tp.pokemon_type_api.controller;


import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eservices.ifi.tp.pokemon_type_api.service.PokemonTypeService;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeService;
    @Autowired
    public PokemonTypeController(PokemonTypeService pokemonTypeService){
        this.pokemonTypeService=pokemonTypeService;
    }


    @GetMapping(value = "/{id}")
    public PokemonType getPokemonTypeFromId(@PathVariable int id) {
        return pokemonTypeService.getPokemonType(id);
    }
    @GetMapping(value = "/")
    public List<PokemonType> getAllPokemonTypes() {
        return pokemonTypeService.getAllPokemonTypes();
    }
    @GetMapping(value = "/search/{name}")
    public PokemonType getPokemonTypeFromName(@PathVariable String name) {
        return pokemonTypeService.getPokemonTypeWithName(name);
    }
    @GetMapping(value = "/search/{types}")
    public List<PokemonType>  getPokemonTypeFromTypes(@PathVariable String types) {
        return pokemonTypeService.getPokemonTypesWithTypes(types);
    }
}
