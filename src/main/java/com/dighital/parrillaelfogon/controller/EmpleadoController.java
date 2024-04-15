package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoEmpleado;
import com.dighital.parrillaelfogon.dto.dtoObjetosMapa;
import com.dighital.parrillaelfogon.entity.Empleado;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServEmpleado;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hag
 */
@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "https://parrielfogon.web.app")
public class EmpleadoController {

    @Autowired
    ServEmpleado serviceEmpleado;

    @GetMapping("/lista")
    public ResponseEntity<List<Empleado>> list() {
        List<Empleado> list = serviceEmpleado.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Empleado> geyById(@PathVariable("id") Long id) {
        if (!serviceEmpleado.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Empleado empleado = serviceEmpleado.getOne(id).get();
        return new ResponseEntity(empleado, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!serviceEmpleado.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        serviceEmpleado.delete(id);
        return new ResponseEntity(new Mensaje("Empleado eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEmpleado dtoEmpleado) {

        if (StringUtils.isBlank(dtoEmpleado.getCodigo())) {
            return new ResponseEntity(new Mensaje("Codigo Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoEmpleado.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Empleado empleado = new Empleado(
                dtoEmpleado.getCodigo(), dtoEmpleado.getNombre(), dtoEmpleado.getContacto(), dtoEmpleado.getEditar());
        serviceEmpleado.save(empleado);
        return new ResponseEntity(new Mensaje("Nuevo empleado creado exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoEmpleado dtoEmpleado) {
        if (!serviceEmpleado.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }

        Empleado empleado = serviceEmpleado.getOne(id).get();

        empleado.setCodigo(dtoEmpleado.getCodigo());
        empleado.setNombre(dtoEmpleado.getNombre());
        empleado.setContacto(dtoEmpleado.getContacto());
        empleado.setEditar(dtoEmpleado.getEditar());

        serviceEmpleado.save(empleado);

        return new ResponseEntity(new Mensaje("Empleado actualizado correctamente"), HttpStatus.OK);
    }

}
