package com.example.demoST;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
@Slf4j
public class MeuService {

    public void processarRequisicaoPost(MeuRequest request) {
        // Implemente o processamento do POST aqui
        log.info("Requisição POST processada");
    }

    public void processarRequisicaoGet(String parametro1, String parametro2) {
        // Implemente o processamento do GET aqui
        log.info("Requisição GET processada com parâmetros: {} e {}", parametro1, parametro2);
    }

    public void processarRequisicaoDelete(Long id) {
        // Implemente o processamento do DELETE aqui
        log.info("Requisição DELETE processada para o ID: {}", id);
    }

    public void processarRequisicaoPut(Long id, MeuRequest request) {
        // Implemente o processamento do PUT aqui
        log.info("Requisição PUT processada para o ID: {}", id);
    }

    public void consumirApiExterna() {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/pikachu";
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

