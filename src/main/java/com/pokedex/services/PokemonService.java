package com.pokedex.data.services;


import com.pokedex.data.entity.Db;
import com.pokedex.data.entity.models.*;
import com.pokedex.data.entity.pokemon.AbbilityBE;
import com.pokedex.data.entity.pokemon.MoveBE;
import com.pokedex.data.entity.pokemon.PokemonBE;
import com.pokedex.data.entity.pokemon.TypeBE;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Component
@Log4j2
@RequiredArgsConstructor
public class PokemonService {

    private final Db db;

    @Transactional
    public void createOrUpdatePokemon(Optional<PokemonModel> pokemonModel, String pokemonName) {
        if (pokemonModel.isPresent()) {
            log.info("processing pokemon {}", pokemonName);

            val pokemon = pokemonModel.get();
            PokemonBE pokemonBE = new PokemonBE();
            pokemonBE.setName(pokemonName);
            getAndUpdateAbilities(pokemon.getAbilities(), pokemonBE);
            getAndUpdateMoves(pokemon.getMoves(), pokemonBE);
            getAndUpdateType(pokemon.getTypes(), pokemonBE);
            getAndUpdateImage(pokemon.getSprites(), pokemonBE);
            db.pokemonRepository().save(pokemonBE);
        }
    }

    private void getAndUpdateAbilities(List<Ability> abilities, PokemonBE pokemonBE) {
        val pokemonAbbilities = pokemonBE.getAbbilities();
        for (Ability ability : abilities) {
            val abbilityBEBuilder = AbbilityBE.builder()
                    .abbilityName(ability.getAbility().getName())
                    .pokemon(pokemonBE)
                    .build();

            pokemonAbbilities.add(abbilityBEBuilder);
        }
        pokemonBE.setAbbilities(pokemonAbbilities);
    }

    private void getAndUpdateMoves(List<Move> moves, PokemonBE pokemonBE) {
        val pokemonMoves = pokemonBE.getMoves();
        for (Move move : moves) {

            val moveBEBuilder = MoveBE.builder()
                    .moveName(move.getMove().getName())
                    .pokemon(pokemonBE)
                    .build();

            pokemonMoves.add(moveBEBuilder);
        }
        pokemonBE.setMoves(pokemonMoves);
    }


    private void getAndUpdateType(List<Type> types, PokemonBE pokemonBE) {
        val pokemonTypes = pokemonBE.getTypes();
        for (Type type : types) {

            val typeBEBuilder = TypeBE.builder()
                    .typeName(type.getType().getName())
                    .pokemon(pokemonBE)
                    .build();

            pokemonTypes.add(typeBEBuilder);
        }
        pokemonBE.setTypes(pokemonTypes);
    }

    private void getAndUpdateImage(Sprites spites, PokemonBE pokemonBE) {
        val artWork = spites.getOther().getOfficialArtwork().getFrontDefault();
        if (!isNull(artWork)) {
            pokemonBE.setImageURL(artWork);
        } else {
            pokemonBE.setImageURL("NO_IMAGE");
        }
    }
}
