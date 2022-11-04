
package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoTicket {
    @NotBlank
    private String listadoArticulos;
    @NotBlank
    private String importe;
    @NotBlank
    private String observacion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String numerodeMesa;
    
    //constructor

    public dtoTicket() {
    }

    public dtoTicket(String importe, String observacion, String fecha, String numerodeMesa) {
        this.importe = importe;
        this.observacion = observacion;
        this.fecha = fecha;
        this.numerodeMesa = numerodeMesa;
    }
    
}
