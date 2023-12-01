package com.example.demoST;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MeuServiceTest {

    @Autowired
    private MeuService meuService;

    @Test
    void testRequisicaoPost() {
        MeuRequest request = new MeuRequest();
        request.setCampoString("Teste");
        request.setCampoNumero(42);
        request.setArray(List.of("elemento1", "elemento2"));

        assertDoesNotThrow(() -> meuService.processarRequisicaoPost(request));
    }

    @Test
    void testRequisicaoGet() {
        assertDoesNotThrow(() -> meuService.processarRequisicaoGet("param1", "param2"));
    }

    @Test
    void testRequisicaoDelete() {
        assertDoesNotThrow(() -> meuService.processarRequisicaoDelete(1L));
    }

    @Test
    void testRequisicaoPut() {
        MeuRequest request = new MeuRequest();
        request.setCampoString("Teste");
        request.setCampoNumero(42);
        request.setArray(List.of("elemento1", "elemento2"));

        assertDoesNotThrow(() -> meuService.processarRequisicaoPut(1L, request));
    }

    @Test
    void testConsumirApiExterna() {
        assertThrows(Exception.class, () -> meuService.consumirApiExterna());
    }
}