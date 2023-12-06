package com.example.demoST;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class MeuService {

    private static final String API_BASE_URL = "https://pokeapi.co/api/v2/";

    public void consumirApiExterna(String endpoint) {
        String apiUrl = API_BASE_URL + endpoint;
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            log.info("Status code da resposta da API externa: {}", response.getStatusCodeValue());

            ObjectMapper objectMapper = new ObjectMapper();
            Pokemon pokemon = objectMapper.readValue(response.getBody(), Pokemon.class);

            log.info("Nome do Pokémon: {}", pokemon.getName());
            log.info("Altura do Pokémon: {}", pokemon.getHeight());
            log.info("Movimentos do Pokémon:");
            for (Pokemon.Move move : pokemon.getMoves()) {
                log.info("- {}", move.getName());
            }
        } catch (Exception e) {
            log.error("Erro ao consumir a API externa", e);
        }
    }
}
