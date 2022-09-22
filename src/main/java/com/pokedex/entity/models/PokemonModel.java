package com.pokedex.entity.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
public class PokemonModel {

    @JsonProperty("moves")
    private List<Move> moves;

    @JsonProperty("abilities")
    private List<Ability> abilities;

    @JsonProperty("types")
    private List<Type> types;

    @JsonProperty("sprites")
    private Sprites sprites;
}
