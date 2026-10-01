package com.civilconection.api.service;

import com.civilconection.api.dto.ProfissionalDTO;
import com.civilconection.api.model.Profissional;
import com.civilconection.api.model.Usuario;
import com.civilconection.api.repository.ProfissionalRepository;
import com.civilconection.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;
    private final UsuarioRepository usuarioRepository;

    public ProfissionalService(ProfissionalRepository profissionalRepository, UsuarioRepository usuarioRepository) {
        this.profissionalRepository = profissionalRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<ProfissionalDTO> listarComFiltros(String profissao, String cidade, String termo) {
        List<Profissional> lista;
        if ((profissao == null || profissao.isBlank()) &&
            (cidade == null || cidade.isBlank()) &&
            (termo == null || termo.isBlank())) {
            lista = profissionalRepository.findAll();
        } else {
            lista = profissionalRepository.buscarComFiltros(
                profissao != null && !profissao.isBlank() ? profissao : null,
                cidade != null && !cidade.isBlank() ? cidade : null,
                termo != null && !termo.isBlank() ? termo : null
            );
        }
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProfissionalDTO buscarPorId(Long id) {
        Profissional p = profissionalRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Profissional não encontrado com ID: " + id));
        return toDTO(p);
    }

    @Transactional
    public ProfissionalDTO salvarOuAtualizar(ProfissionalDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + dto.getUsuarioId()));

        Profissional p = profissionalRepository.findByUsuarioId(dto.getUsuarioId())
                .orElse(new Profissional());

        p.setUsuario(usuario);
        p.setProfissao(dto.getProfissao());
        p.setCidade(dto.getCidade());
        p.setDescricao(dto.getDescricao());
        if (dto.getAvaliacao() != null) {
            p.setAvaliacao(dto.getAvaliacao());
        }
        p.setEspecialidades(dto.getEspecialidades());
        p.setContato(dto.getContato() != null ? dto.getContato() : usuario.getEmail());

        // Ensure user type is PROFISSIONAL
        if (!"PROFISSIONAL".equalsIgnoreCase(usuario.getTipo())) {
            usuario.setTipo("PROFISSIONAL");
            usuarioRepository.save(usuario);
        }

        Profissional salvo = profissionalRepository.save(p);
        return toDTO(salvo);
    }

    @Transactional
    public void deletar(Long id) {
        if (!profissionalRepository.existsById(id)) {
            throw new IllegalArgumentException("Profissional não encontrado com ID: " + id);
        }
        profissionalRepository.deleteById(id);
    }

    public ProfissionalDTO toDTO(Profissional p) {
        if (p == null) return null;
        return new ProfissionalDTO(
                p.getId(),
                p.getUsuario() != null ? p.getUsuario().getId() : null,
                p.getUsuario() != null ? p.getUsuario().getNome() : null,
                p.getUsuario() != null ? p.getUsuario().getEmail() : null,
                p.getProfissao(),
                p.getCidade(),
                p.getDescricao(),
                p.getAvaliacao(),
                p.getEspecialidades(),
                p.getContato()
        );
    }
}
