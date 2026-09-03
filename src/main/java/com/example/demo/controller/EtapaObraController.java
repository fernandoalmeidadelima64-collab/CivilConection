package com.example.demo.controller;

import com.example.demo.entity.EtapaObra;
import com.example.demo.repository.EtapaObraRepository;
import com.example.demo.repository.ObraRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etapas")
public class EtapaObraController {

    private final EtapaObraRepository etapaObraRepository;
    private final ObraRepository obraRepository;

    public EtapaObraController(EtapaObraRepository etapaObraRepository, ObraRepository obraRepository) {
        this.etapaObraRepository = etapaObraRepository;
        this.obraRepository = obraRepository;
    }

    @GetMapping
    public List<EtapaObra> listarTodas() {
        return etapaObraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtapaObra> buscarPorId(@PathVariable Long id) {
        return etapaObraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/obra/{obraId}")
    public ResponseEntity<EtapaObra> criar(@PathVariable Long obraId, @Valid @RequestBody EtapaObra etapa) {
        return obraRepository.findById(obraId)
                .map(obra -> {
                    etapa.setObra(obra);
                    return ResponseEntity.ok(etapaObraRepository.save(etapa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtapaObra> atualizar(@PathVariable Long id, @Valid @RequestBody EtapaObra etapaAtualizada) {
        return etapaObraRepository.findById(id)
                .map(etapa -> {
                    etapa.setNome(etapaAtualizada.getNome());
                    etapa.setStatus(etapaAtualizada.getStatus());
                    return ResponseEntity.ok(etapaObraRepository.save(etapa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (etapaObraRepository.existsById(id)) {
            etapaObraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
