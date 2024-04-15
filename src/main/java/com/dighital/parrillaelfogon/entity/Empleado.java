package com.dighital.parrillaelfogon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hag
 */
@Getter
@Setter
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private String contacto;
    private String editar;

    //constructor
    public Empleado() {
    }

    public Empleado(String codigo, String nombre, String contacto, String editar) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contacto = contacto;
        this.editar = editar;
    }

}
