package com.emprestimo.aplicacao.emprestimo_app.model.item;

import com.emprestimo.aplicacao.emprestimo_app.model.categoria.Categoria;
import com.emprestimo.aplicacao.emprestimo_app.model.item.qr.QrCode;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Table(name = "tb_item")
@Entity
public class Item  {

    @Column(name = "item_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name", nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT", name = "item_description")
    @Lob
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "qr_code")
    private QrCode qr_code;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Categoria> categorias = new HashSet<>();

    @Column(columnDefinition = "JSON")
    //@Type(JsonType.class)
    @Convert(converter = DetalhesConverter.class)
    private Detalhes detalhes;


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qr_code=" + qr_code +
                ", categorias=" + categorias +
                ", detalhes=" + detalhes +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(qr_code, item.qr_code) && Objects.equals(categorias, item.categorias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, qr_code, categorias);
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public QrCode getQr_code() {
        return qr_code;
    }

    public void setQr_code(QrCode qr_code) {
        this.qr_code = qr_code;
    }

    public Detalhes getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(Detalhes detalhes) {
        this.detalhes = detalhes;
    }
}
