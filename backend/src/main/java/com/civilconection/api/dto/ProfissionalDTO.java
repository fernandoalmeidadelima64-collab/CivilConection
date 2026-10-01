package com.civilconection.api.dto;

public class ProfissionalDTO {
    private Long id;
    private Long usuarioId;
    private String nome;
    private String email;
    private String profissao;
    private String cidade;
    private String descricao;
    private Double avaliacao;
    private String especialidades;
    private String contato;

    public ProfissionalDTO() {
    }

    public ProfissionalDTO(Long id, Long usuarioId, String nome, String email, String profissao, String cidade, String descricao, Double avaliacao, String especialidades, String contato) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.profissao = profissao;
        this.cidade = cidade;
        this.descricao = descricao;
        this.avaliacao = avaliacao;
        this.especialidades = especialidades;
        this.contato = contato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
