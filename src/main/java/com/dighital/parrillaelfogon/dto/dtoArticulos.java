
package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoArticulos {
    @NotBlank
    private String nombre;
    @NotBlank
    private String familia;
    @NotBlank
    private int stock;
    @NotBlank
    private int puntorepo;
    @NotBlank
    private int costo;
    @NotBlank
    private int precioventa;
    @NotBlank
    private int stockinicial;
    @NotBlank
    private String imagen;
    private int cantidad;
    private String checkEdit;
    
    
    //constructor

    public dtoArticulos() {
    }

    public dtoArticulos(String nombre, String familia, int stock, int puntorepo, int costo, int precioventa, int stockinicial,
                        String imagen, int cantidad, String checkEdit) {
        this.nombre = nombre;
        this.familia = familia;
        this.stock = stock;
        this.puntorepo = puntorepo;
        this.costo = costo;
        this.precioventa = precioventa;
        this.stockinicial = stockinicial;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.checkEdit = checkEdit;
    }
    
}
