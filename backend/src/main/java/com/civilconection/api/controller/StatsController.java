package com.civilconection.api.controller;

import com.civilconection.api.dto.StatsDTO;
import com.civilconection.api.repository.ObraRepository;
import com.civilconection.api.repository.ProfissionalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final ObraRepository obraRepository;
    private final ProfissionalRepository profissionalRepository;

    public StatsController(ObraRepository obraRepository, ProfissionalRepository profissionalRepository) {
        this.obraRepository = obraRepository;
        this.profissionalRepository = profissionalRepository;
    }

    @GetMapping
    public ResponseEntity<StatsDTO> obterEstatisticas() {
        long obrasConcluidas = obraRepository.countByStatus("CONCLUIDA");
        long totalObras = obraRepository.count();
        long profissionaisCadastrados = profissionalRepository.count();

        double mediaAvaliacao = profissionalRepository.findAll().stream()
                .mapToDouble(p -> p.getAvaliacao() != null ? p.getAvaliacao() : 5.0)
                .average()
                .orElse(4.9);

        // Round media to 1 decimal place
        mediaAvaliacao = Math.round(mediaAvaliacao * 10.0) / 10.0;

        StatsDTO stats = new StatsDTO(
                obrasConcluidas,
                profissionaisCadastrados,
                totalObras,
                mediaAvaliacao
        );

        return ResponseEntity.ok(stats);
    }
}
