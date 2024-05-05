package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto solo creado con la finalidad de actualizar la propiedad stock del
 * articulo, dejando las otras propiedades iguales.
 *
 * @author Hag
 */
@Getter
@Setter
public class dtoArticuloStock {

    @NotBlank
    private int stock;

    //constructor
    public dtoArticuloStock() {
    }

    public dtoArticuloStock(int stock) {
        this.stock = stock;
    }

}
