package com.eservices.ifi.tp.pokemon_type_api.controller;

import com.eservices.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eservices.ifi.tp.pokemon_type_api.service.PokemonTypeService;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PokemonTypeControllerTest {

    @Test
    void getPokemonType_shouldCallTheService() {
        PokemonTypeService service = mock(PokemonTypeService.class);
        PokemonTypeController controller = new PokemonTypeController(service);

        PokemonType pikachu = new PokemonType();
        pikachu.setId(25);
        pikachu.setName("pikachu");
        when(service.getPokemonType(25)).thenReturn(pikachu);

        PokemonType pokemon = controller.getPokemonTypeFromId(25);
        assertEquals("pikachu", pokemon.getName());

        verify(service).getPokemonType(25);
    }

    @Test
    void getAllPokemonTypes_shouldCallTheService() {
        PokemonTypeService service = mock(PokemonTypeService.class);
        PokemonTypeController controller = new PokemonTypeController(service);

        controller.getAllPokemonTypes();

        verify(service).getAllPokemonTypes();
    }

    @Test
    void pokemonTypeController_shouldBeAnnotated(){
        RestController controllerAnnotation = PokemonTypeController.class.getAnnotation(RestController.class);
        assertNotNull(controllerAnnotation);

        RequestMapping requestMappingAnnotation =
                PokemonTypeController.class.getAnnotation(RequestMapping.class);
        assertArrayEquals(new String[]{"/pokemon-types"}, requestMappingAnnotation.value());
    }

    @Test
    void getPokemonTypeFromId_shouldBeAnnotated() throws NoSuchMethodException {
        Method getPokemonTypeFromId =
                PokemonTypeController.class.getDeclaredMethod("getPokemonTypeFromId", int.class);
        GetMapping getMapping = getPokemonTypeFromId.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{id}"}, getMapping.value());
    }

    @Test
    void getAllPokemonTypes_shouldBeAnnotated() throws NoSuchMethodException {
        Method getAllPokemonTypes =
                PokemonTypeController.class.getDeclaredMethod("getAllPokemonTypes");
        GetMapping getMapping = getAllPokemonTypes.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value());
    }
}