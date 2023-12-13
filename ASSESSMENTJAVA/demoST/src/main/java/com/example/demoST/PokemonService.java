package com.example.demoST;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokemonService {

    private Map<Long, Pokemon> pokemons = iniciarPokes();
    private long lastId = pokemons.size();

    private Map<Long, Pokemon> iniciarPokes() {
        Map<Long, Pokemon> pokemons = new HashMap<>();
        for(int i=1; i<=151; i++){
            PokeUtil pokeUtil = new PokeUtil();
            Pokemon pokemon = pokeUtil.getPokemon((long)i);
            pokemons.put((long)i,pokemon);
        }
        return pokemons;
    }
    public void create(Pokemon pokemon) {
        Long id = ++this.lastId;
        pokemon.setId(id);
        pokemons.put(id,pokemon);
    }

    public List<Pokemon> getAllPokemon() {
        return pokemons.values().stream().toList();
    }

   public Pokemon getPokemonById(Long id) {
return pokemons.get(id);

    }

     public void update(long id, Pokemon atualizado) {
        atualizado.setId(id);
        pokemons.replace(id,atualizado);
    }


    public void deleteById(long id) {
        Pokemon pokemon = pokemons.remove(id);
        if (pokemon == null){
            try {
                throw new ResorceNotFoundException("Pokemon não existe");
            } catch (ResorceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public List<Pokemon> filterByName(String nome) {
        List<Pokemon> all = getAllPokemon();
        return all.stream().filter(pokemon -> pokemon.getName().startsWith(nome)).toList();
    }
}
