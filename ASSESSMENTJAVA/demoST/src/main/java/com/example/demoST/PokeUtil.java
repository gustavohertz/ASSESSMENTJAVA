package com.example.demoST;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PokeUtil {
    private final String URL = "https://pokeapi.co/api/v2/pokemon/";

    public Pokemon getPokemon(Long id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(URL + id))
                    .build();

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = JsonMapper.builder().addModule(new JavaTimeModule()).build();
            Pokemon pokemonDetails = mapper.readValue(response.body(), Pokemon.class);

            List<String> habil = getPokeHabilidades(pokemonDetails);
            int altura = pokemonDetails.getHeight();
            String nome = pokemonDetails.getName();


            Pokemon pokemon = new Pokemon(id, nome, altura, habil);
            return pokemon;

        }catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private List<String> getPokeHabilidades(Pokemon poke) {
        List<String> habilidades = new LinkedList<>();
        for (int i = 0; i < poke.getAbilities().size(); i++) {
            Object tipos = poke.getAbilities().get(i);

            if (tipos instanceof Map) {
                Map<String, Object> tiposList = (Map<String, Object>) tipos;
                Object tipoList = tiposList.get("ability");
                if (tipoList instanceof Map) {
                    Map<String, Object> habilidadeList = (Map<String, Object>) tipoList;
                    Object nomeHabilidade = habilidadeList.get("name");
                    habilidades.add(nomeHabilidade.toString());
                }
            }
        }
        return habilidades;
    }

}
