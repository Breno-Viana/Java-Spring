package com.emprestimo.aplicacao.emprestimo_app.model.categoria;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    public Categoria(String categoria){
        this.categoria=categoria;
    }
    public Categoria(){}

    @Id
    @Column(name = "cl_categoria")
    private String categoria;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria1 = (Categoria) o;
        return Objects.equals(categoria, categoria1.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoria);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
