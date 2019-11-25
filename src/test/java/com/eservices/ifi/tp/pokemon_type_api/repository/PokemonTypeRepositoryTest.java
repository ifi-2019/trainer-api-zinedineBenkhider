package com.eservices.ifi.tp.pokemon_type_api.repository;

import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTypeRepositoryTest {
    private PokemonTypeRepositoryImpl repository = new PokemonTypeRepositoryImpl();
    @Test
    void applicationContext_shouldLoadPokemonRepository(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.eservices.ifi.tp.pokemon_type_api.repository");
        PokemonTypeRepository repoByName = (PokemonTypeRepository)context.getBean("pokemonTypeRepositoryImpl");
        PokemonTypeRepository repoByClass = context.getBean(PokemonTypeRepository.class);

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }
    @Test
    void findPokemonById_with25_shouldReturnPikachu(){
        PokemonType pikachu = repository.findPokemonTypeById(25);
        assertNotNull(pikachu);
        assertEquals("pikachu", pikachu.getName());
        assertEquals(25, pikachu.getId());
    }

    @Test
    void findPokemonById_with145_shouldReturnZapdos(){
        PokemonType zapdos = repository.findPokemonTypeById(145);
        assertNotNull(zapdos);
        assertEquals("zapdos", zapdos.getName());
        assertEquals(145, zapdos.getId());
    }

    @Test
    void findPokemonByName_withEevee_shouldReturnEevee(){
        PokemonType eevee = repository.findPokemonTypeByName("eevee");
        assertNotNull(eevee);
        assertEquals("eevee", eevee.getName());
        assertEquals(133, eevee.getId());
    }

    @Test
    void findPokemonByName_withMewTwo_shouldReturnMewTwo(){
        PokemonType mewtwo = repository.findPokemonTypeByName("mewtwo");
        assertNotNull(mewtwo);
        assertEquals("mewtwo", mewtwo.getName());
        assertEquals(150, mewtwo.getId());
    }

    @Test
    void findAllPokemon_shouldReturn151Pokemons(){
       List<PokemonType> pokemons = repository.findAllPokemonType();
        assertNotNull(pokemons);
        assertEquals(151, pokemons.size());
    }
}