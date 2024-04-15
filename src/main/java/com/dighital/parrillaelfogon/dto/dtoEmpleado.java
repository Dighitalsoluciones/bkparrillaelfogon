package com.dighital.parrillaelfogon.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Hag
 */
@Getter
@Setter
public class dtoEmpleado {

    @NotBlank
    private String codigo;
    @NotBlank
    private String nombre;
    private String contacto;
    private String editar;

    //constructor
    public dtoEmpleado() {
    }

    public dtoEmpleado(String codigo, String nombre, String contacto, String editar) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contacto = contacto;
        this.editar = editar;
    }

}
