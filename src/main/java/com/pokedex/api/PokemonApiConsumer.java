package com.pokedex.api;

import com.pokedex.entity.models.PokemonModel;
import com.pokedex.entity.models.PokemonapiV2;
import com.pokedex.entity.models.Result;
import com.pokedex.services.PokemonService;
import com.pokedex.utils.RestUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.Objects.isNull;

@Log4j2
@Service
@RequiredArgsConstructor
public class PokemonApiConsumer {

    private static final String POKEMON_LIST_LIMIT_URL = "/pokemon/?limit=%s";
    private final PokemonService pokemonService;
    private final RestTemplate restTemplate;
    private final RetryTemplate retryTemplate;
    @Value("${pokemon.v2.url}")
    private String BASE_URL;

    @EventListener(ApplicationReadyEvent.class) //Wait for app start event , startup at app start event.
    @Scheduled(cron = "0 0 * * * *") //Run once a day
    public void consumePokemonData() {
        log.info("Running api consumer...");
        val batchSize = 100;

        /**
         * @Disclaimer
         * Don't have much understanding of pokemon hence unsure of the api data consumed and
         * the style in which the data is consumed in respect to relations ect... hence this is not
         * a true representation of what the pokemon represents.
         *
         * @ConsumerProcess
         * Basic consumption :
         * 1. Get 100 Data objects at a time from the provided API
         * 2. That data object contains a secondary link to get metadata for the data object
         * 3. For each data object request the metadata for the object
         * 4. Process and persist the data to the DB.
         *
         * Consumer to run once a day to get latest data from pokemon API
         * */

        //TODO implement retry template for api consumer of main API and secondary detials API.
        String batchUrl = String.format(BASE_URL + POKEMON_LIST_LIMIT_URL, batchSize);
        while (!batchUrl.isEmpty()) {
            val optionalPokemonapiV2List = RestUtil.get(restTemplate, batchUrl, null, PokemonapiV2.class);
            if (optionalPokemonapiV2List.isPresent()) {
                val pokemonApiV2 = optionalPokemonapiV2List.get();
                if (isNull(pokemonApiV2.getNext())) {
                    log.info("Consumption completed...next page not provided");
                    return;
                }
                val nextBatchUrl = pokemonApiV2.getNext();
                batchUrl = nextBatchUrl;
                val result = pokemonApiV2.getResults();
                processAndFetchPokemonDetails(result);
            }else{
                return;
            }
        }
    }

    public void processAndFetchPokemonDetails(List<Result> simplePokemonArray) {
        //TODO Implement batching of list and async processing of each batch for faster processing.
      CompletableFuture.runAsync(() -> {
          for (Result result : simplePokemonArray) {
              val pokemonName = result.getName();
              val detailsUrl = result.getUrl();
              if (!pokemonName.isEmpty() && !detailsUrl.isEmpty()) {
                  val pokemonDO = RestUtil.get(restTemplate, detailsUrl, null, PokemonModel.class);
                  if (pokemonDO.isPresent()) {
                      pokemonService.createOrUpdatePokemon(pokemonDO, pokemonName);
                  }
              }
          }
      });

    }

}
