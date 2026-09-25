package com.civilconection.api.repository;

import com.civilconection.api.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    Optional<Profissional> findByUsuarioId(Long usuarioId);

    @Query("SELECT p FROM Profissional p WHERE " +
           "(:profissao IS NULL OR LOWER(p.profissao) LIKE LOWER(CONCAT('%', :profissao, '%'))) AND " +
           "(:cidade IS NULL OR LOWER(p.cidade) LIKE LOWER(CONCAT('%', :cidade, '%'))) AND " +
           "(:termo IS NULL OR LOWER(p.usuario.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR LOWER(p.profissao) LIKE LOWER(CONCAT('%', :termo, '%')) OR LOWER(p.especialidades) LIKE LOWER(CONCAT('%', :termo, '%')))")
    List<Profissional> buscarComFiltros(
            @Param("profissao") String profissao,
            @Param("cidade") String cidade,
            @Param("termo") String termo
    );
}
