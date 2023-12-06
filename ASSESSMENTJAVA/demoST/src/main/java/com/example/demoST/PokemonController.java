package com.example.demoST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping
    public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.createPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon criado com sucesso");
    }


    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();
        return ResponseEntity.ok(pokemonList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Pokemon pokemon = pokemonService.getPokemonById(id);
        return ResponseEntity.ok(pokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        pokemonService.updatePokemon(id, pokemon);
        return ResponseEntity.ok("Pokemon atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.ok("Pokemon excluído com sucesso");
    }
}