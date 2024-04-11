package com.dighital.parrillaelfogon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hag
 */
@Getter
@Setter
@Entity
public class ObjetosMapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "imagen", nullable = false, length = 450)
    private String imagen;
    private int x;
    private int y;
    private int rotacion;
    private int ancho;
    private int largo;
    private String texto;
    private String colorText;

    //constructor
    public ObjetosMapa() {
    }

    public ObjetosMapa(String imagen, int x, int y, int rotacion, int ancho, int largo, String texto, String colorText) {
        this.imagen = imagen;
        this.x = x;
        this.y = y;
        this.rotacion = rotacion;
        this.ancho = ancho;
        this.largo = largo;
        this.texto = texto;
        this.colorText = colorText;
    }

}
