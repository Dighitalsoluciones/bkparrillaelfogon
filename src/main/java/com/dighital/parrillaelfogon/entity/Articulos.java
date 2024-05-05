package com.dighital.parrillaelfogon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Articulos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String familia;
    private int stock;
    private int puntorepo;
    private int costo;
    private int precioventa;
    private int stockinicial;
    @Column(name = "imagen", nullable = false, length = 450)
    private String imagen;
    private int cantidad;
    private String checkEdit;
    @Column(name = "isTrazable", nullable = false, columnDefinition = "varchar(255) default 'false'")
    private String isTrazable;

    //Constructor
    public Articulos() {
    }

    public Articulos(String nombre, String familia, int stock, int puntorepo, int costo, int precioventa, int stockinicial, String imagen, int cantidad, String checkEdit, String isTrazable) {
        this.nombre = nombre;
        this.familia = familia;
        this.stock = stock;
        this.puntorepo = puntorepo;
        this.costo = costo;
        this.precioventa = precioventa;
        this.stockinicial = stockinicial;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.checkEdit = checkEdit;
        this.isTrazable = isTrazable;
    }

}
