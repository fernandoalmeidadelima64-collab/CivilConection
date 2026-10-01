package com.civilconection.api.controller;

import com.civilconection.api.dto.ProfissionalDTO;
import com.civilconection.api.service.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalDTO>> listar(
            @RequestParam(required = false) String profissao,
            @RequestParam(required = false) String cidade,
            @RequestParam(required = false) String termo) {
        return ResponseEntity.ok(profissionalService.listarComFiltros(profissao, cidade, termo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(profissionalService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProfissionalDTO> salvar(@Valid @RequestBody ProfissionalDTO dto) {
        ProfissionalDTO salvo = profissionalService.salvarOuAtualizar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ProfissionalDTO dto) {
        dto.setId(id);
        ProfissionalDTO atualizado = profissionalService.salvarOuAtualizar(dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        profissionalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
