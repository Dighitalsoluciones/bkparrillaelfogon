package com.dighital.parrillaelfogon.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hag
 */
@Entity
@Getter
@Setter
public class MovimientoStock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String listadoItem;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    private String observacion;

    //constructor
    public MovimientoStock() {
    }

    public MovimientoStock(String listadoItem, Date fecha, String observacion) {
        this.listadoItem = listadoItem;
        this.fecha = fecha;
        this.observacion = observacion;
    }

}
