package com.civilconection.api.repository;

import com.civilconection.api.model.Obra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ObraRepository extends JpaRepository<Obra, Long> {
    List<Obra> findByClienteId(Long clienteId);
    long countByStatus(String status);

    @Query("SELECT o FROM Obra o WHERE " +
           "(:categoria IS NULL OR LOWER(o.categoria) = LOWER(:categoria)) AND " +
           "(:status IS NULL OR LOWER(o.status) = LOWER(:status)) AND " +
           "(:cidade IS NULL OR LOWER(o.cidade) LIKE LOWER(CONCAT('%', :cidade, '%'))) AND " +
           "(:termo IS NULL OR LOWER(o.nome) LIKE LOWER(CONCAT('%', :termo, '%')) OR LOWER(o.descricao) LIKE LOWER(CONCAT('%', :termo, '%')))")
    List<Obra> buscarComFiltros(
            @Param("categoria") String categoria,
            @Param("status") String status,
            @Param("cidade") String cidade,
            @Param("termo") String termo
    );
}
