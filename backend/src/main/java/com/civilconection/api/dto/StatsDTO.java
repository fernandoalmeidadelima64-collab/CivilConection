package com.civilconection.api.dto;

public class StatsDTO {
    private long obrasConcluidas;
    private long profissionaisCadastrados;
    private long totalObras;
    private double satisfacaoMedia;

    public StatsDTO() {
    }

    public StatsDTO(long obrasConcluidas, long profissionaisCadastrados, long totalObras, double satisfacaoMedia) {
        this.obrasConcluidas = obrasConcluidas;
        this.profissionaisCadastrados = profissionaisCadastrados;
        this.totalObras = totalObras;
        this.satisfacaoMedia = satisfacaoMedia;
    }

    public long getObrasConcluidas() {
        return obrasConcluidas;
    }

    public void setObrasConcluidas(long obrasConcluidas) {
        this.obrasConcluidas = obrasConcluidas;
    }

    public long getProfissionaisCadastrados() {
        return profissionaisCadastrados;
    }

    public void setProfissionaisCadastrados(long profissionaisCadastrados) {
        this.profissionaisCadastrados = profissionaisCadastrados;
    }

    public long getTotalObras() {
        return totalObras;
    }

    public void setTotalObras(long totalObras) {
        this.totalObras = totalObras;
    }

    public double getSatisfacaoMedia() {
        return satisfacaoMedia;
    }

    public void setSatisfacaoMedia(double satisfacaoMedia) {
        this.satisfacaoMedia = satisfacaoMedia;
    }
}
