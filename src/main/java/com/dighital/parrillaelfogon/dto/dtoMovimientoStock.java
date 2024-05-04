package com.dighital.parrillaelfogon.dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hag
 */
@Getter
@Setter
public class dtoMovimientoStock {

    @NotBlank
    private String listadoItem;
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String observacion;

    //constructor
    public dtoMovimientoStock() {
    }

    public dtoMovimientoStock(String listadoItem, Date fecha, String observacion) {
        this.listadoItem = listadoItem;
        this.fecha = fecha;
        this.observacion = observacion;
    }

}
