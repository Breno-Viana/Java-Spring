package com.emprestimo.aplicacao.emprestimo_app.model.item;

import java.io.Serializable;

public class Detalhes implements Serializable {
    private String detalhes;
    private String codigoDeSerie;


    public Detalhes(String detalhes, String codigoDeSerie) {
        this.detalhes = detalhes;
        this.codigoDeSerie = codigoDeSerie;
    }

    public Detalhes() {
    }

    @Override
    public String toString() {
        return "Detalhes{" +
                "detalhes='" + detalhes + '\'' +
                ", codigoDeSerie='" + codigoDeSerie + '\'' +
                '}';
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getCodigoDeSerie() {
        return codigoDeSerie;
    }

    public void setCodigoDeSerie(String codigoDeSerie) {
        this.codigoDeSerie = codigoDeSerie;
    }
}
