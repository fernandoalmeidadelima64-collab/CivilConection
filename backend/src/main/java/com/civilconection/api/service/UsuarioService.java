package com.civilconection.api.service;

import com.civilconection.api.dto.UsuarioCreateDTO;
import com.civilconection.api.dto.UsuarioDTO;
import com.civilconection.api.model.Usuario;
import com.civilconection.api.repository.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + id));
        return toDTO(usuario);
    }

    @Transactional
    public UsuarioDTO criar(UsuarioCreateDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado: " + dto.getEmail());
        }

        String hashedPassword = BCrypt.hashpw(dto.getSenha(), BCrypt.gensalt());
        Usuario usuario = new Usuario(null, dto.getNome(), dto.getEmail(), hashedPassword, dto.getTipo());
        Usuario salvo = usuarioRepository.save(usuario);
        return toDTO(salvo);
    }

    @Transactional
    public UsuarioDTO atualizar(Long id, UsuarioCreateDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com ID: " + id));

        if (!usuario.getEmail().equalsIgnoreCase(dto.getEmail()) && usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado: " + dto.getEmail());
        }

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        if (dto.getSenha() != null && !dto.getSenha().isBlank()) {
            usuario.setSenha(BCrypt.hashpw(dto.getSenha(), BCrypt.gensalt()));
        }
        if (dto.getTipo() != null) {
            usuario.setTipo(dto.getTipo());
        }

        return toDTO(usuarioRepository.save(usuario));
    }

    @Transactional
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTipo());
    }
}
