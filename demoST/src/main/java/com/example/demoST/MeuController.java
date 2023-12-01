package com.example.demoST;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MeuController {

    @Autowired
    private MeuService meuService;

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
        meuService.consumirApiExterna();
        return ResponseEntity.ok("API externa consumida com sucesso");
    }
}
