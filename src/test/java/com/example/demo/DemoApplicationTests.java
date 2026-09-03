package com.example.demo;

import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testUsuarioRepositoryOperations() {
		Usuario novoUsuario = Usuario.builder()
				.nome("João Silva")
				.email("joao@example.com")
				.senha("123456")
				.build();

		Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);
		assertThat(usuarioSalvo.getId()).isNotNull();

		Optional<Usuario> usuarioBuscado = usuarioRepository.findById(usuarioSalvo.getId());
		assertThat(usuarioBuscado).isPresent();
		assertThat(usuarioBuscado.get().getNome()).isEqualTo("João Silva");

		usuarioRepository.deleteById(usuarioSalvo.getId());
		assertThat(usuarioRepository.findById(usuarioSalvo.getId())).isEmpty();
	}
}
