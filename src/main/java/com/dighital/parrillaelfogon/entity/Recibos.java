
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
public class Recibos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fecha;
    private String corresTicket;
    private String importe;
    private String observacion;
    private String numerodeMesa;
    private String formadepago;
    
    //constructor

    public Recibos() {
    }

    public Recibos(String fecha, String corresTicket, String importe, String observacion, String numerodeMesa, String formadepago) {
        this.fecha = fecha;
        this.corresTicket = corresTicket;
        this.importe = importe;
        this.observacion = observacion;
        this.numerodeMesa = numerodeMesa;
        this.formadepago = formadepago;
    }
    
}
