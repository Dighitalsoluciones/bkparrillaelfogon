
package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoEgresos;
import com.dighital.parrillaelfogon.entity.Egresos;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServEgresos;
import java.util.List;
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

@RestController
@RequestMapping("/egresos")
@CrossOrigin(origins = "https://parrielfogon.web.app")
public class EgresosController {
    
    @Autowired
    ServEgresos sEgresos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Egresos>> list() {
        List<Egresos> list = sEgresos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Egresos> geyById(@PathVariable("id") int id){
        if(!sEgresos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Egresos egresos = sEgresos.getOne(id).get();
        return new ResponseEntity(egresos ,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEgresos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sEgresos.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEgresos dtoegresos) {
        
        Egresos egresos = new Egresos(
                dtoegresos.getFecha(), dtoegresos.getImporte(), dtoegresos.getTipodegasto(), dtoegresos.getRealizadopor(), dtoegresos.getObservacion(), dtoegresos.getMostrar());
        sEgresos.save(egresos);
        return new ResponseEntity(new Mensaje("Nuevo Egreso creado exitosamente"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEgresos dtoegresos){
        if(!sEgresos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sEgresos.existByMostrar(dtoegresos.getMostrar()) && sEgresos.
                getByFecha(dtoegresos.getFecha()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Campo existente"), HttpStatus.BAD_REQUEST);
    }
               
        Egresos egresos = sEgresos.getOne(id).get();
        
        egresos.setFecha(dtoegresos.getFecha());
        egresos.setImporte(dtoegresos.getImporte());
        egresos.setTipodegasto(dtoegresos.getTipodegasto());
        egresos.setRealizadopor(dtoegresos.getRealizadopor());
        egresos.setObservacion(dtoegresos.getObservacion());
        egresos.setMostrar(dtoegresos.getMostrar());
        
       
               
        sEgresos.save(egresos);
        
        return new ResponseEntity(new Mensaje("Egreso actualizada correctamente"), HttpStatus.OK);
    }
}
