
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
public class Egresos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fecha;
    private int importe;
    private String tipodegasto;
    private String realizadopor;
    private String observacion;
    private String mostrar;
    
    //constructor

    public Egresos() {
    }

    public Egresos(String fecha, int importe, String tipodegasto, String realizadopor, String observacion, String mostrar) {
        this.fecha = fecha;
        this.importe = importe;
        this.tipodegasto = tipodegasto;
        this.realizadopor = realizadopor;
        this.observacion = observacion;
        this.mostrar = mostrar;
    }
    
}
