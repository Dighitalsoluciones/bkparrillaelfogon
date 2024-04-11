package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hag
 */
@Getter
@Setter
public class dtoObjetosMapa {

    @NotBlank
    private String imagen;
    private int x;
    private int y;
    private int rotacion;
    private int ancho;
    private int largo;
    private String texto;
    private String colorText;

    //constructor
    public dtoObjetosMapa() {
    }

    public dtoObjetosMapa(String imagen, int x, int y, int rotacion, int ancho, int largo, String texto, String colorText) {
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
