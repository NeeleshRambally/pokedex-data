package com.example.demo.entity;

import com.example.demo.entity.pokemon.PokemonBE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<PokemonBE, String> {
}
