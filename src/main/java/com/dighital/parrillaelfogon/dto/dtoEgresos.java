
package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class dtoEgresos {
    @NotBlank
    private String fecha;
    @NotBlank
    private int importe;
    @NotBlank
    private String tipodegasto;
    @NotBlank
    private String realizadopor;
    @NotBlank
    private String observacion;
    @NotBlank
    private String mostrar;
    @NotBlank
    private String checkEd;

    public dtoEgresos() {
    }

    public dtoEgresos(String fecha, int importe, String tipodegasto, String realizadopor, String observacion, String mostrar, String checkEd) {
        this.fecha = fecha;
        this.importe = importe;
        this.tipodegasto = tipodegasto;
        this.realizadopor = realizadopor;
        this.observacion = observacion;
        this.mostrar = mostrar;
        this.checkEd = checkEd;
    }
    
    
}
