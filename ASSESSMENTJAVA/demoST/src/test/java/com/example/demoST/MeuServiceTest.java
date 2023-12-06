package com.example.demoST;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PokemonServiceTest {

    @Autowired
    private PokemonService pokemonService;

    @Test
    void testCreatePokemon() {
        Pokemon pokemon = new Pokemon("Pikachu", 40, List.of(new Pokemon.Move("Thunder Shock")));
        assertDoesNotThrow(() -> pokemonService.createPokemon(pokemon));
    }

    @Test
    void testGetAllPokemon() {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();
        assertNotNull(pokemonList);
    }

    @Test
    void testGetPokemonById() {
        // Crie um Pokemon para usar no teste
        Pokemon pokemon = new Pokemon("Charmander", 30, List.of(new Pokemon.Move("Ember")));
        pokemonService.createPokemon(pokemon);

        // Obtenha o ID do Pokemon
        Long id = pokemon.getId();

        // Chame o método getPokemonById com o ID inicializado
        Pokemon retrievedPokemon = pokemonService.getPokemonById(id);

        assertNotNull(retrievedPokemon);
        assertEquals(id, retrievedPokemon.getId());
    }

    @Test
    void testUpdatePokemon() {
        // Crie um Pokemon para usar no teste
        Pokemon pokemon = new Pokemon("Squirtle", 35, List.of(new Pokemon.Move("Water Gun")));
        pokemonService.createPokemon(pokemon);

        // Obtenha o ID do Pokemon
        Long id = pokemon.getId();

        // Crie um novo Pokemon para atualização
        Pokemon updatedPokemon = new Pokemon("Wartortle", 45, List.of(new Pokemon.Move("Bubble Beam")));
        assertDoesNotThrow(() -> pokemonService.updatePokemon(id, updatedPokemon));
    }

    @Test
    void testDeletePokemon() {
        Pokemon pokemon = new Pokemon("Bulbasaur", 35, List.of(new Pokemon.Move("Vine Whip")));
        pokemonService.createPokemon(pokemon);

        Long id = pokemon.getId(); // Obtém o ID do Pokémon criado
        assertDoesNotThrow(() -> pokemonService.deletePokemon(id));
    }

}

