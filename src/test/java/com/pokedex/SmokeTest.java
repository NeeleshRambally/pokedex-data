package com.pokedex;

import com.pokedex.entity.pokemon.PokemonBE;
import com.pokedex.services.PokemonService;
import com.pokedex.testUtils.AbstractIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SmokeTest extends AbstractIT {

    @Autowired
    PokemonService pokemonService;

    @Test
    void testConsumptionOfPokemonApi() {
        List<PokemonBE> pokemonBEList = executeSQL("select p.name from pokemon p", PokemonBE.class);
        assertFalse(pokemonBEList.isEmpty());
    }

    //TODO: Add additional use test cases...

}
