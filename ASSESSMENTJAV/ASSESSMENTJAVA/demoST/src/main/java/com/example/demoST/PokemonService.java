package com.example.demoST;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
@Service
public class PokemonService {
    private Map<Long, Pokemon> pokemons = new HashMap<>();
    private Long lastId = 0L;

    @Autowired
    private PokemonUtil pokemonUtil;

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 151; i++) {
            Pokemon poke = pokemonUtil.getPokemon(i);
            Pokemon p1 = new Pokemon(poke.getId(), poke.getName(), poke.getHeight(), poke.getAbilities());
            pokemons.put(p1.getId(), p1);
        }
        lastId = Long.valueOf(pokemons.size());
    }

    public List<Pokemon> getAll() {
        return pokemons.values().stream().toList();
    }

    public Pokemon getPokeById(long id) {
        Pokemon pokemon = pokemons.get(id);
        if (pokemon == null) {
            throw new ResorceNotFoundException("Pokemon não encontrado");
        }
        return pokemon;
    }

    public void create(Pokemon pokemon) {
        Long id = ++this.lastId;
        pokemon.setId(id);
        pokemons.put(id, pokemon);
    }

    public void deleteById(long id) {
        Pokemon pokemon = pokemons.remove(id);
        if (pokemon == null) {
            throw new ResorceNotFoundException("Pokemon não existe");
        }
    }

    public void update(long id, Pokemon atualizado) {
        atualizado.setId(id);
        pokemons.replace(id, atualizado);
    }

    public List<Pokemon> filterByName(String nome) {
        List<Pokemon> all = getAll();
        return all.stream().filter(pokemon -> pokemon.getName().startsWith(nome)).toList();
    }
}
