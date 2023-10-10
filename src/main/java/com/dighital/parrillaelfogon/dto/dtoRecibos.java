package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoRecibos {

    @NotBlank
    private String fecha;
    @NotBlank
    private String corresTicket;
    @NotBlank
    private int importe;
    @NotBlank
    private String observacion;
    @NotBlank
    private String numerodeMesa;
    @NotBlank
    private String formadepago;
     @NotBlank
    private String checkEd;

    //constructor

    public dtoRecibos() {
    }

    public dtoRecibos(String fecha, String corresTicket, int importe, String observacion, String numerodeMesa, String formadepago, String checkEd) {
        this.fecha = fecha;
        this.corresTicket = corresTicket;
        this.importe = importe;
        this.observacion = observacion;
        this.numerodeMesa = numerodeMesa;
        this.formadepago = formadepago;
        this.checkEd = checkEd;
    }
    
}
