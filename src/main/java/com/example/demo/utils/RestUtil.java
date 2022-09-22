package com.example.demo.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class RestUtil {

    public static <T> Optional<T> get(RestTemplate template, String url, String bearerToken, Class<T> clazz) {
        return get(template.exchange(url, HttpMethod.GET, null, clazz));
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
