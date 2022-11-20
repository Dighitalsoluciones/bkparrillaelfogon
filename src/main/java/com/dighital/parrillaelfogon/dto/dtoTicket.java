
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
    private int importe;
    @NotBlank
    private String observacion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String numerodeMesa;
    @NotBlank
    private String formadepago;
    
    //constructor

    public dtoTicket() {
    }

    public dtoTicket(int importe, String observacion, String fecha, String numerodeMesa, String formadepago) {
        this.importe = importe;
        this.observacion = observacion;
        this.fecha = fecha;
        this.numerodeMesa = numerodeMesa;
        this.formadepago = formadepago;
    }
    
}
