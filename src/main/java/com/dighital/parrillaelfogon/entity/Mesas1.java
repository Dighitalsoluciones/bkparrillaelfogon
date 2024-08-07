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
public class Mesas1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;
    @Column(name = "comanda", length = 2000)
    private String comanda;
    private String cierre;
    private String liquidada;

    @Column(name = "imagen", nullable = false, length = 450)
    private String imagen;
    private String numeroMesa;
    @Column(name = "totalComanda", nullable = false)
    private String totalComanda;
    private String comensales;
    private String impresion;
    private int x;
    private int y;
    private int rotacion;
    private String mesero;

    //Constructor
    public Mesas1() {
    }

    public Mesas1(String estado, String comanda, String cierre, String liquidada, String imagen, String numeroMesa, String totalComanda, String comensales, String impresion, int x, int y, int rotacion, String mesero) {
        this.estado = estado;
        this.comanda = comanda;
        this.cierre = cierre;
        this.liquidada = liquidada;
        this.imagen = imagen;
        this.numeroMesa = numeroMesa;
        this.totalComanda = totalComanda;
        this.comensales = comensales;
        this.impresion = impresion;
        this.x = x;
        this.y = y;
        this.rotacion = rotacion;
        this.mesero = mesero;
    }

}
