package com.civilconection.api.repository;

import com.civilconection.api.model.EtapaObra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EtapaObraRepository extends JpaRepository<EtapaObra, Long> {
    List<EtapaObra> findByObraIdOrderByOrdemAsc(Long obraId);
}
