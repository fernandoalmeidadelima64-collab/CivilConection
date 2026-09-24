package com.civilconection.api.service;

import com.civilconection.api.dto.EtapaObraDTO;
import com.civilconection.api.model.EtapaObra;
import com.civilconection.api.model.Obra;
import com.civilconection.api.repository.EtapaObraRepository;
import com.civilconection.api.repository.ObraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtapaObraService {

    private final EtapaObraRepository etapaObraRepository;
    private final ObraRepository obraRepository;

    public EtapaObraService(EtapaObraRepository etapaObraRepository, ObraRepository obraRepository) {
        this.etapaObraRepository = etapaObraRepository;
        this.obraRepository = obraRepository;
    }

    @Transactional(readOnly = true)
    public List<EtapaObraDTO> listarTodas() {
        return etapaObraRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EtapaObraDTO> listarPorObra(Long obraId) {
        return etapaObraRepository.findByObraIdOrderByOrdemAsc(obraId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EtapaObraDTO buscarPorId(Long id) {
        EtapaObra etapa = etapaObraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Etapa não encontrada com ID: " + id));
        return toDTO(etapa);
    }

    @Transactional
    public EtapaObraDTO criarOuAtualizar(EtapaObraDTO dto) {
        Obra obra = obraRepository.findById(dto.getObraId())
                .orElseThrow(() -> new IllegalArgumentException("Obra não encontrada com ID: " + dto.getObraId()));

        EtapaObra etapa;
        if (dto.getId() != null && etapaObraRepository.existsById(dto.getId())) {
            etapa = etapaObraRepository.findById(dto.getId()).get();
        } else {
            etapa = new EtapaObra();
        }

        etapa.setObra(obra);
        etapa.setNome(dto.getNome());
        etapa.setDescricao(dto.getDescricao());
        if (dto.getStatus() != null) etapa.setStatus(dto.getStatus());
        if (dto.getProgresso() != null) etapa.setProgresso(dto.getProgresso());
        if (dto.getOrdem() != null) etapa.setOrdem(dto.getOrdem());

        EtapaObra salva = etapaObraRepository.save(etapa);

        // Recalculate Obra overall progress if stages exist
        recalcularProgressoObra(obra);

        return toDTO(salva);
    }

    @Transactional
    public void deletar(Long id) {
        EtapaObra etapa = etapaObraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Etapa não encontrada com ID: " + id));
        Obra obra = etapa.getObra();
        etapaObraRepository.delete(etapa);
        if (obra != null) {
            recalcularProgressoObra(obra);
        }
    }

    private void recalcularProgressoObra(Obra obra) {
        List<EtapaObra> etapas = etapaObraRepository.findByObraIdOrderByOrdemAsc(obra.getId());
        if (!etapas.isEmpty()) {
            double media = etapas.stream().mapToInt(EtapaObra::getProgresso).average().orElse(0.0);
            obra.setProgresso((int) Math.round(media));
            if (obra.getProgresso() >= 100) {
                obra.setStatus("CONCLUIDA");
            } else if (obra.getProgresso() > 0) {
                obra.setStatus("EM_ANDAMENTO");
            }
            obraRepository.save(obra);
        }
    }

    public EtapaObraDTO toDTO(EtapaObra e) {
        if (e == null) return null;
        return new EtapaObraDTO(
                e.getId(),
                e.getObra() != null ? e.getObra().getId() : null,
                e.getNome(),
                e.getDescricao(),
                e.getStatus(),
                e.getProgresso(),
                e.getOrdem()
        );
    }
}
