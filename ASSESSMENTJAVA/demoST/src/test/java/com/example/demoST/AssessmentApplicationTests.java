package com.example.demoST;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Log
@SpringBootTest
class AssessmentApplicationTests {

	@Test
	void testGetPokemon(){
		PokeUtil pokeUtil = new PokeUtil();
		Pokemon pokemon = pokeUtil.getPokemon(1L);
		System.out.println(pokemon);
	}
	@Test
	void testQuantidade(){
	PokemonService	pokemonService = new PokemonService();

		log.info("Quantidade:"+pokemonService.getAllPokemon());
		assertEquals(151,pokemonService.getAllPokemon().size());
	}
	@Test
	void testGetById(){
		PokemonService	pokemonService = new PokemonService();
		log.info(""+pokemonService.getPokemonById(54L));
	}
}
