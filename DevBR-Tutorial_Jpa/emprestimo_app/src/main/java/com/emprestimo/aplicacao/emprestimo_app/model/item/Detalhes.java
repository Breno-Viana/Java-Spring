package com.emprestimo.aplicacao.emprestimo_app.model.item;


import java.io.Serializable;

public class Detalhes implements Serializable {

   private  String modelo;

    public Detalhes(String garrafaPet) {
        this.modelo=garrafaPet;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Detalhes{" +
                "modelo='" + modelo + '\'' +
                '}';
    }
}
