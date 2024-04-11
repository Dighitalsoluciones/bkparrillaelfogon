package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoMesas1 {

    @NotBlank
    private String estado;
    @NotBlank
    private String comanda;
    @NotBlank
    private String cierre;
    @NotBlank
    private String liquidada;
    @NotBlank
    private String imagen;
    @NotBlank
    private String numeroMesa;
    @NotBlank
    private String totalComanda;
    @NotBlank
    private String comensales;
    @NotBlank
    private String impresion;

    private int x;

    private int y;

    private int rotacion;

    //constructor
    public dtoMesas1() {
    }

    public dtoMesas1(String estado, String comanda, String cierre, String liquidada, String imagen, String numeroMesa, String totalComanda, String comensales, String impresion, int x, int y, int rotacion) {
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
    }

}
