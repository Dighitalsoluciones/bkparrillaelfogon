
package com.dighital.parrillaelfogon.entity;

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
    private String stock;
    private String puntorepo;
    private String costo;
    private String precioventa;
    private String stockinicial;
    
    //Constructor

    public Articulos() {
    }

    public Articulos(String nombre, String familia, String stock, String puntorepo, String costo, String precioventa, String stockinicial) {
        this.nombre = nombre;
        this.familia = familia;
        this.stock = stock;
        this.puntorepo = puntorepo;
        this.costo = costo;
        this.precioventa = precioventa;
        this.stockinicial = stockinicial;
    }
    
    
}