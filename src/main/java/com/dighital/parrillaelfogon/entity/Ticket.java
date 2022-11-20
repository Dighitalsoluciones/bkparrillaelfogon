
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
    private int importe;
    private String observacion;
    private String fecha;
    private String numerodeMesa;
    private String formadepago;
    
    //constructor

    public Ticket() {
    }

    public Ticket(String listadoArticulos, int importe, String observacion, String fecha, String numerodeMesa, String formadepago) {
        this.listadoArticulos = listadoArticulos;
        this.importe = importe;
        this.observacion = observacion;
        this.fecha = fecha;
        this.numerodeMesa = numerodeMesa;
        this.formadepago = formadepago;
    }

  
}
