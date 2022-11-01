
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
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "listadoArticulos", nullable = false, length = 10000)
    private String listadoArticulos;
    private String importe;
    private String observacion;
    private String fecha;
    
    //constructor

    public Ticket() {
    }

    public Ticket(String listadoArticulos, String importe, String observacion, String fecha) {
        this.listadoArticulos = listadoArticulos;
        this.importe = importe;
        this.observacion = observacion;
        this.fecha = fecha;
    }

  
}
