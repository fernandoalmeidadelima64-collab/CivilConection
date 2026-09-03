package com.example.demo.controller;

import com.example.demo.entity.Obra;
import com.example.demo.repository.ObraRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraController {

    private final ObraRepository obraRepository;

    public ObraController(ObraRepository obraRepository) {
        this.obraRepository = obraRepository;
    }

    @GetMapping
    public List<Obra> listarTodas() {
        return obraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Obra> buscarPorId(@PathVariable Long id) {
        return obraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Obra criar(@Valid @RequestBody Obra obra) {
        if (obra.getEtapas() != null) {
            obra.getEtapas().forEach(etapa -> etapa.setObra(obra));
        }
        return obraRepository.save(obra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Obra> atualizar(@PathVariable Long id, @Valid @RequestBody Obra obraAtualizada) {
        return obraRepository.findById(id)
                .map(obra -> {
                    obra.setNome(obraAtualizada.getNome());
                    obra.setEndereco(obraAtualizada.getEndereco());
                    obra.setStatus(obraAtualizada.getStatus());
                    return ResponseEntity.ok(obraRepository.save(obra));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (obraRepository.existsById(id)) {
            obraRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
