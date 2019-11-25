package com.eservices.ifi.tp.pokemon_type_api.repository;

import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository{
    private List<PokemonType> pokemons;
    public PokemonTypeRepositoryImpl(){

        try {
            InputStream pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            ObjectMapper objectMapper = new ObjectMapper();
            PokemonType[] pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokemonType findPokemonTypeById(int id ) {
        Boolean found=false;
        int i=0;
        PokemonType pokemon=null;
       while (!found && i<this.pokemons.size()){
           pokemon=pokemons.get(i);
           if (pokemon.getId()==id){
               return pokemon;
           }
           i++;
       }
        return null;
    }

    public PokemonType findPokemonTypeByName(String name){
        Boolean found=false;
        int i=0;
        PokemonType pokemon=null;
        while (!found && i<this.pokemons.size()){
            pokemon=pokemons.get(i);
            if (pokemon.getName().equals(name)){
                return pokemon;
            }
            i++;
        }
        return null;

    }

    public List<PokemonType> findAllPokemonType(){
        List<PokemonType> listPokemons=new ArrayList<>();


        return this.pokemons;
    }
    public List<PokemonType> findAllPokemonTypeWithType(String type){
        Boolean found=false;
        List<PokemonType> lisPokemons=new ArrayList<>();
        int i=0;


            PokemonType pokemon=null;
            while (!found && i<this.pokemons.size()){
                pokemon=pokemons.get(i);
                if (pokemon.getType().equals(type)){
                    lisPokemons.add(pokemon);
                }
                i++;
            }
            return lisPokemons;
        }

    @Override
    public List<PokemonType> findAllPokemonTypeWithTypes(String types) {
        List<PokemonType> lisPokemons=new ArrayList<>();
        String[] typesList=types.split("'");
        for (int i=0;i<typesList.length;i++){
            lisPokemons.addAll(findAllPokemonTypeWithType(typesList[i]));
        }
    return lisPokemons;

    }
}
