package com.civilconection.api.dto;

import java.util.List;

public class ObraDTO {
    private Long id;
    private Long clienteId;
    private String clienteNome;
    private String nome;
    private String descricao;
    private String cidade;
    private String status;
    private String categoria;
    private Integer progresso;
    private List<EtapaObraDTO> etapas;

    public ObraDTO() {
    }

    public ObraDTO(Long id, Long clienteId, String clienteNome, String nome, String descricao, String cidade, String status, String categoria, Integer progresso, List<EtapaObraDTO> etapas) {
        this.id = id;
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
        this.nome = nome;
        this.descricao = descricao;
        this.cidade = cidade;
        this.status = status;
        this.categoria = categoria;
        this.progresso = progresso;
        this.etapas = etapas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
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

    public List<EtapaObraDTO> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<EtapaObraDTO> etapas) {
        this.etapas = etapas;
    }
}
