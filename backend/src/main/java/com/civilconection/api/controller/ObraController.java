package com.civilconection.api.controller;

import com.civilconection.api.dto.ObraDTO;
import com.civilconection.api.service.ObraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private final ObraService obraService;

    public ObraController(ObraService obraService) {
        this.obraService = obraService;
    }

    @GetMapping
    public ResponseEntity<List<ObraDTO>> listar(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String cidade,
            @RequestParam(required = false) String termo) {
        return ResponseEntity.ok(obraService.listarComFiltros(categoria, status, cidade, termo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObraDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(obraService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ObraDTO> criar(@Valid @RequestBody ObraDTO dto) {
        ObraDTO criada = obraService.criarOuAtualizar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObraDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ObraDTO dto) {
        dto.setId(id);
        ObraDTO atualizada = obraService.criarOuAtualizar(dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        obraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
