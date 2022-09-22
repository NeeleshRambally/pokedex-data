package com.example.demo.api;

import com.example.demo.entity.models.PokemonModel;
import com.example.demo.entity.models.PokemonapiV2;
import com.example.demo.entity.models.Result;
import com.example.demo.services.PokemonService;
import com.example.demo.utils.RestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class PokemonApiConsumer {

    private static final String POKEMON_LIST_LIMIT_URL = "/pokemon/?limit=%s";
    private final PokemonService pokemonService;
    private final RestTemplate restTemplate;
    @Value("${pokemon.v2.url}")
    private String BASE_URL;

    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "0 0 * * * *")
    public void consumePokemonData() {
        log.info("Running api consumer...");
        val batchSize = 100;

        String batchUrl = String.format(BASE_URL + POKEMON_LIST_LIMIT_URL, batchSize);
        while (!batchUrl.isEmpty()) {
            val optionalPokemonapiV2List = RestUtil.get(restTemplate, batchUrl, null, PokemonapiV2.class);
            if (optionalPokemonapiV2List.isPresent()) {
                val pokemonApiV2 = optionalPokemonapiV2List.get();
                if (pokemonApiV2.getNext().isEmpty()) {
                    log.info("Consumption completed.");
                    return;
                }
                val nextBatchUrl = pokemonApiV2.getNext();
                batchUrl = nextBatchUrl;
                val result = pokemonApiV2.getResults();
                processAndFetchPokemonDetails(result);

            } else {
                batchUrl = "";
            }
        }
    }

    public void processAndFetchPokemonDetails(List<Result> simplePokemonArray) {
        for (Result result : simplePokemonArray) {

            val pokemonName = result.getName();
            val detailsUrl = result.getUrl();

            if (!pokemonName.isEmpty() && !detailsUrl.isEmpty()) {
                val pokemonDO = RestUtil.get(restTemplate, detailsUrl, null, PokemonModel.class);
                pokemonService.createOrUpdatePokemon(pokemonDO, pokemonName);
            }
        }
    }

}
