package com.pokedex.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.util.Arrays;
import java.util.Optional;

@Log4j2
public class RestUtil {

    public static <T> Optional<T> get(RestTemplate template, String url, String bearerToken, Class<T> clazz) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("User-Agent", "Mozilla/5.0 Firefox/26.0");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            return get(template.exchange(url, HttpMethod.GET, entity, clazz));
        } catch (UnknownHttpStatusCodeException unknownHttpStatusCodeException) {
            log.error("Error with {}", url);
        } catch (ResourceAccessException resourceAccessException) {
            log.error("Cannot connect to url {}", url);
        }
        return Optional.empty();
    }

    private static <T> Optional<T> get(ResponseEntity<T> response) {

        if (response.getStatusCode().is2xxSuccessful()) {
            return Optional.ofNullable(response.getBody());
        }

        if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
