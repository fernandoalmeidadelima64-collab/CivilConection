package com.civilconection.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "obras")
public class Obra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @NotBlank(message = "O nome da obra é obrigatório")
    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String cidade;

    private String status = "EM_ANDAMENTO"; // EM_ANDAMENTO, PLANEJAMENTO, CONCLUIDA

    private String categoria = "RESIDENCIAL"; // RESIDENCIAL, COMERCIAL, INFRAESTRUTURA

    private Integer progresso = 0; // 0 a 100

    @OneToMany(mappedBy = "obra", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("ordem ASC")
    private List<EtapaObra> etapas = new ArrayList<>();

    public Obra() {
    }

    public Obra(Long id, Usuario cliente, String nome, String descricao, String cidade, String status, String categoria, Integer progresso) {
        this.id = id;
        this.cliente = cliente;
        this.nome = nome;
        this.descricao = descricao;
        this.cidade = cidade;
        this.status = status != null ? status : "EM_ANDAMENTO";
        this.categoria = categoria != null ? categoria : "RESIDENCIAL";
        this.progresso = progresso != null ? progresso : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getProgresso() {
        return progresso;
    }

    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }

    public List<EtapaObra> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<EtapaObra> etapas) {
        this.etapas = etapas;
    }

    public void addEtapa(EtapaObra etapa) {
        etapas.add(etapa);
        etapa.setObra(this);
    }

    public void removeEtapa(EtapaObra etapa) {
        etapas.remove(etapa);
        etapa.setObra(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Obra obra = (Obra) o;
        return Objects.equals(id, obra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
