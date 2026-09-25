package com.civilconection.api.dto;

public class EtapaObraDTO {
    private Long id;
    private Long obraId;
    private String nome;
    private String descricao;
    private String status;
    private Integer progresso;
    private Integer ordem;

    public EtapaObraDTO() {
    }

    public EtapaObraDTO(Long id, Long obraId, String nome, String descricao, String status, Integer progresso, Integer ordem) {
        this.id = id;
        this.obraId = obraId;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.progresso = progresso;
        this.ordem = ordem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObraId() {
        return obraId;
    }

    public void setObraId(Long obraId) {
        this.obraId = obraId;
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
}
