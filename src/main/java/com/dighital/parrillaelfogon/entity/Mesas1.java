
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
public class Mesas1 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;
    private String comanda;
    private String cierre;
    private String liquidada;
    
    //Constructor

    public Mesas1() {
    }

    public Mesas1(String estado, String comanda, String cierre, String liquidada) {
        this.estado = estado;
        this.comanda = comanda;
        this.cierre = cierre;
        this.liquidada = liquidada;
    }
    
}
