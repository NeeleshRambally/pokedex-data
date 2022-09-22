package com.pokedex.data.entity;

import com.pokedex.data.entity.pokemon.PokemonBE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonBE, String> {
}
