package com.javer.clientes.gateway.model;

public class Cliente {
    private Long id;
    private String nome;
    private Long telefone;
    private Boolean correntista;
    private Float scoreCredito;
    private Float saldoCc;


    public Float getSaldoCc() {
        return saldoCc;
    }

    public void setSaldoCc(Float saldoCc) {
        this.saldoCc = saldoCc;
    }

    public Float getScoreCredito() {
        return scoreCredito;
    }

    public void setScoreCredito(Float scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

    public Boolean getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Boolean correntista) {
        this.correntista = correntista;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
