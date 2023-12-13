package com.example.demoST;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
        try {
            pokemonService.create(pokemon);
            return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon criado com sucesso");
        } catch (Exception e) {
            log.warning("Erro ao criar o Pokemon: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao criar o Pokemon", e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        try {
            List<Pokemon> pokemonList = pokemonService.getAll();
            return ResponseEntity.ok(pokemonList);
        } catch (Exception e) {
            log.warning("Erro ao obter a lista de Pokemon: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao obter a lista de Pokemon", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        try {
            Pokemon pokemon = pokemonService.getPokeById(id);
            return ResponseEntity.ok(pokemon);
        } catch (PokemonNotFoundException e) {
            log.warning("Pokemon não encontrado: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon não encontrado", e);
        } catch (Exception e) {
            log.warning("Erro ao obter o Pokemon: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao obter o Pokemon", e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        try {
            pokemonService.update(id, pokemon);
            return ResponseEntity.ok("Pokemon atualizado com sucesso");
        } catch (PokemonNotFoundException e) {
            log.warning("Pokemon não encontrado para atualização: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon não encontrado para atualização", e);
        } catch (Exception e) {
            log.warning("Erro ao atualizar o Pokemon: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar o Pokemon", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePokemon(@PathVariable Long id) {
        try {
            pokemonService.deleteById(id);
            return ResponseEntity.ok("Pokemon excluído com sucesso");
        } catch (PokemonNotFoundException e) {
            log.warning("Pokemon não encontrado para exclusão: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon não encontrado para exclusão", e);
        } catch (Exception e) {
            log.warning("Erro ao excluir o Pokemon: " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao excluir o Pokemon", e);
        }
    }
}
