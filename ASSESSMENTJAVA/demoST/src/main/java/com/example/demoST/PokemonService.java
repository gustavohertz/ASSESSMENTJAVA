package com.example.demoST;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PokemonService {

    private final List<Pokemon> pokemonList = new ArrayList<>();

    public void createPokemon(Pokemon pokemon) {
        // Lógica para criar um novo Pokemon
        pokemonList.add(pokemon);
    }

    public List<Pokemon> getAllPokemon() {
        // Lógica para obter todos os Pokemon
        return pokemonList;
    }

    public Pokemon getPokemonById(Long id) {
        return pokemonList.stream()
                .filter(pokemon -> Objects.equals(pokemon.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public void updatePokemon(Long id, Pokemon updatedPokemon) {
        Pokemon existingPokemon = getPokemonById(id);
        if (existingPokemon != null) {
            existingPokemon.setName(updatedPokemon.getName());
            existingPokemon.setHeight(updatedPokemon.getHeight());
            existingPokemon.setMoves(updatedPokemon.getMoves());
        } else {
            // Adicione lógica para tratar o caso em que o Pokemon não foi encontrado
            try {
                throw new PokemonNotFoundException("Pokemon não encontrado para o ID: " + id);
            } catch (PokemonNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deletePokemon(Long id) {
        pokemonList.removeIf(pokemon -> Objects.equals(pokemon.getId(), id));
    }

}
