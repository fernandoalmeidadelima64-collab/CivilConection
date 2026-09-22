package com.civilconection.api.service;

import com.civilconection.api.dto.EtapaObraDTO;
import com.civilconection.api.dto.ObraDTO;
import com.civilconection.api.model.EtapaObra;
import com.civilconection.api.model.Obra;
import com.civilconection.api.model.Usuario;
import com.civilconection.api.repository.ObraRepository;
import com.civilconection.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService {

    private final ObraRepository obraRepository;
    private final UsuarioRepository usuarioRepository;

    public ObraService(ObraRepository obraRepository, UsuarioRepository usuarioRepository) {
        this.obraRepository = obraRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<ObraDTO> listarComFiltros(String categoria, String status, String cidade, String termo) {
        List<Obra> lista;
        if ((categoria == null || categoria.isBlank()) &&
            (status == null || status.isBlank()) &&
            (cidade == null || cidade.isBlank()) &&
            (termo == null || termo.isBlank())) {
            lista = obraRepository.findAll();
        } else {
            lista = obraRepository.buscarComFiltros(
                categoria != null && !categoria.isBlank() ? categoria : null,
                status != null && !status.isBlank() ? status : null,
                cidade != null && !cidade.isBlank() ? cidade : null,
                termo != null && !termo.isBlank() ? termo : null
            );
        }
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ObraDTO buscarPorId(Long id) {
        Obra obra = obraRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Obra não encontrada com ID: " + id));
        return toDTO(obra);
    }

    @Transactional
    public ObraDTO criarOuAtualizar(ObraDTO dto) {
        Usuario cliente = usuarioRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com ID: " + dto.getClienteId()));

        Obra obra;
        if (dto.getId() != null && obraRepository.existsById(dto.getId())) {
            obra = obraRepository.findById(dto.getId()).get();
        } else {
            obra = new Obra();
        }

        obra.setCliente(cliente);
        obra.setNome(dto.getNome());
        obra.setDescricao(dto.getDescricao());
        obra.setCidade(dto.getCidade());
        if (dto.getStatus() != null) obra.setStatus(dto.getStatus());
        if (dto.getCategoria() != null) obra.setCategoria(dto.getCategoria());
        if (dto.getProgresso() != null) obra.setProgresso(dto.getProgresso());

        Obra salva = obraRepository.save(obra);
        return toDTO(salva);
    }

    @Transactional
    public void deletar(Long id) {
        if (!obraRepository.existsById(id)) {
            throw new IllegalArgumentException("Obra não encontrada com ID: " + id);
        }
        obraRepository.deleteById(id);
    }

    public ObraDTO toDTO(Obra obra) {
        if (obra == null) return null;
        List<EtapaObraDTO> etapasDTO = obra.getEtapas() != null ?
                obra.getEtapas().stream().map(this::etapaToDTO).collect(Collectors.toList()) :
                List.of();

        return new ObraDTO(
                obra.getId(),
                obra.getCliente() != null ? obra.getCliente().getId() : null,
                obra.getCliente() != null ? obra.getCliente().getNome() : null,
                obra.getNome(),
                obra.getDescricao(),
                obra.getCidade(),
                obra.getStatus(),
                obra.getCategoria(),
                obra.getProgresso(),
                etapasDTO
        );
    }

    public EtapaObraDTO etapaToDTO(EtapaObra e) {
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
