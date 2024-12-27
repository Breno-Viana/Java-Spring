package com.emprestimo.aplicacao.emprestimo_app.model.item;

import jakarta.persistence.Embeddable;

import java.util.Objects;


@Embeddable
public class NumeroDeSerie {



    private String grupo;
    private String modelo;
    private Integer numero;


    public NumeroDeSerie(String grupo, String modelo, Integer numero) {
        this.grupo = grupo;
        this.modelo = modelo;
        this.numero = numero;
    }

    public NumeroDeSerie() {
    }

    @Override
    public String toString() {
        return "NumeroDeSerie{" +
                "grupo='" + grupo + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NumeroDeSerie that = (NumeroDeSerie) o;
        return Objects.equals(grupo, that.grupo) && Objects.equals(modelo, that.modelo) && Objects.equals(numero, that.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupo, modelo, numero);
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
