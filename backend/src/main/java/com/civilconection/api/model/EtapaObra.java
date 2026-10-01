package com.civilconection.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "etapas_obra")
public class EtapaObra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obra_id", nullable = false)
    private Obra obra;

    @NotBlank(message = "O nome da etapa é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String status = "PENDENTE"; // PENDENTE, EM_ANDAMENTO, CONCLUIDO

    private Integer progresso = 0; // 0 a 100

    private Integer ordem = 1;

    public EtapaObra() {
    }

    public EtapaObra(Long id, Obra obra, String nome, String descricao, String status, Integer progresso, Integer ordem) {
        this.id = id;
        this.obra = obra;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status != null ? status : "PENDENTE";
        this.progresso = progresso != null ? progresso : 0;
        this.ordem = ordem != null ? ordem : 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtapaObra etapaObra = (EtapaObra) o;
        return Objects.equals(id, etapaObra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
