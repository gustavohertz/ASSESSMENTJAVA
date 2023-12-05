package com.example.demoST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeuController {

    private final MeuService meuService;

    public MeuController(MeuService meuService) {
        this.meuService = meuService;
    }

    @PostMapping("/endpointPost")
    public ResponseEntity<String> endpointPost(@RequestBody MeuRequest request) {
        meuService.processarRequisicaoPost(request);
        return ResponseEntity.ok("Requisição POST processada com sucesso");
    }

    @GetMapping("/endpointGet")
    public ResponseEntity<String> endpointGet(
            @RequestParam(required = false) String parametro1,
            @RequestParam(required = false) String parametro2) {
        meuService.processarRequisicaoGet(parametro1, parametro2);
        return ResponseEntity.ok("Requisição GET processada com sucesso");
    }

    @DeleteMapping("/endpointDelete/{id}")
    public ResponseEntity<String> endpointDelete(@PathVariable Long id) {
        meuService.processarRequisicaoDelete(id);
        return ResponseEntity.ok("Requisição DELETE processada com sucesso");
    }

    @PutMapping("/endpointPut/{id}")
    public ResponseEntity<String> endpointPut(@PathVariable Long id, @RequestBody MeuRequest request) {
        meuService.processarRequisicaoPut(id, request);
        return ResponseEntity.ok("Requisição PUT processada com sucesso");
    }

    @GetMapping("/consumirApiExterna")
    public ResponseEntity<String> consumirApiExterna() {
        try {
            meuService.consumirApiExterna();
            return ResponseEntity.ok("API externa consumida com sucesso");
        } catch (ApiExternaException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao consumir a API externa: " + e.getMessage());
        }
    }
}
