package com.example.demo.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

public class RestUtil {

    public static <T> Optional<T> get(RestTemplate template, String url, String bearerToken, Class<T> clazz) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("User-Agent","Mozilla/5.0 Firefox/26.0");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        return get(template.exchange(url, HttpMethod.GET,entity, clazz));
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
