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
    private String importe;
    @NotBlank
    private String observacion;
    @NotBlank
    private String numerodeMesa;
    @NotBlank
    private String formadepago;

    //constructor

    public dtoRecibos() {
    }

    public dtoRecibos(String fecha, String corresTicket, String importe, String observacion, String numerodeMesa, String formadepago) {
        this.fecha = fecha;
        this.corresTicket = corresTicket;
        this.importe = importe;
        this.observacion = observacion;
        this.numerodeMesa = numerodeMesa;
        this.formadepago = formadepago;
    }
    
}
