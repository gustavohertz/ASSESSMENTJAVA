package com.example.demoST;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class pokemonServiceTest {

    @Autowired
    private MeuService meuService;

    @Test
    void testConsumirApiExterna() {
        String endpoint = "https://pokeapi.co/api/v2/pokemon/ditto"; // Você pode ajustar o endpoint conforme necessário
        assertDoesNotThrow(() -> meuService.consumirApiExterna(endpoint));
    }
}

