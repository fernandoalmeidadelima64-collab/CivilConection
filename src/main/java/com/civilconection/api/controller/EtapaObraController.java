package com.civilconection.api.controller;

import com.civilconection.api.dto.EtapaObraDTO;
import com.civilconection.api.service.EtapaObraService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etapas")
public class EtapaObraController {

    private final EtapaObraService etapaObraService;

    public EtapaObraController(EtapaObraService etapaObraService) {
        this.etapaObraService = etapaObraService;
    }

    @GetMapping
    public ResponseEntity<List<EtapaObraDTO>> listar(@RequestParam(required = false) Long obraId) {
        if (obraId != null) {
            return ResponseEntity.ok(etapaObraService.listarPorObra(obraId));
        }
        return ResponseEntity.ok(etapaObraService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtapaObraDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(etapaObraService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<EtapaObraDTO> criar(@Valid @RequestBody EtapaObraDTO dto) {
        EtapaObraDTO criada = etapaObraService.criarOuAtualizar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtapaObraDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EtapaObraDTO dto) {
        dto.setId(id);
        EtapaObraDTO atualizada = etapaObraService.criarOuAtualizar(dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        etapaObraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
