package com.example.demoST;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PokemonUtil {
    private final String URL = "https://pokeapi.co/api/v2/pokemon/";

    public Pokemon getPokemon(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(URL + id))
                    .build();

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            PokemonDetails pokemonDetails = mapper.readValue(response.body(), PokemonDetails.class);

            String nomePokemon = pokemonDetails.getName();
            int AlturaPokemon = pokemonDetails.getHeight();
            String movesPokemon = pokemonDetails.getMovesUrl();
            int idPokemon = pokemonDetails.getId();

                Pokemon pokemon = new Pokemon((Integer) idPokemon, AlturaPokemon, nomePokemon, movesPokemon );

                return pokemon;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            log.error("Erro ao obter detalhes do Pokémon.", e);
            throw new RuntimeException(e);
        }
    }
}
