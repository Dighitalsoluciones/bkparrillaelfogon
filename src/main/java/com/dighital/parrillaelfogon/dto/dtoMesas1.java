
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
   
    
    //constructor

    public dtoMesas1() {
    }

    public dtoMesas1(String comanda, String cierre, String liquidada, String imagen, String numeroMesa) {
        this.comanda = comanda;
        this.cierre = cierre;
        this.liquidada = liquidada;
        this.imagen = imagen;
        this.numeroMesa = numeroMesa;
    }
    
}
