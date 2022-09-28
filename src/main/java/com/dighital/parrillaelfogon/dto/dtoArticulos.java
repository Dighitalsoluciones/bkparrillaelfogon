
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
    private String stock;
    @NotBlank
    private String puntorepo;
    @NotBlank
    private String costo;
    @NotBlank
    private String precioventa;
    @NotBlank
    private String stockinicial;
    
    //constructor

    public dtoArticulos() {
    }

    public dtoArticulos(String nombre, String familia, String stock, String puntorepo, String costo, String precioventa, String stockinicial) {
        this.nombre = nombre;
        this.familia = familia;
        this.stock = stock;
        this.puntorepo = puntorepo;
        this.costo = costo;
        this.precioventa = precioventa;
        this.stockinicial = stockinicial;
    }
    
}
