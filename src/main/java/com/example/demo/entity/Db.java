package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

@Getter
@Repository
@Accessors(fluent = true)
@RequiredArgsConstructor
public class Db {
    private final PokemonRepository pokemonRepository;
}
