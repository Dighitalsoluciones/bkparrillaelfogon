package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoMesas1;
import com.dighital.parrillaelfogon.entity.Mesas1;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServMesa1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/mesas1")
@CrossOrigin(origins = "http://localhost:4200")
public class Mesas1Controller {
    
    @Autowired()
    ServMesa1 sMesas1;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Mesas1>> list() {
        List<Mesas1> list = sMesas1.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Mesas1> geyById(@PathVariable("id") int id) {
        if (!sMesas1.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Mesas1 mesas1 = sMesas1.getOne(id).get();
        return new ResponseEntity(mesas1, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sMesas1.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sMesas1.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoMesas1 dtomesas1) {
        
        Mesas1 mesas1 = new Mesas1(
                dtomesas1.getEstado(), dtomesas1.getComanda(), dtomesas1.getCierre(), dtomesas1.getLiquidada(),
                dtomesas1.getImagen(), dtomesas1.getNumeroMesa(), dtomesas1.getTotalComanda(), dtomesas1.getComensales(),
                dtomesas1.getImpresion(), dtomesas1.getX(), dtomesas1.getY(), dtomesas1.getRotacion(), dtomesas1.getMesero());
        sMesas1.save(mesas1);
        return new ResponseEntity(new Mensaje("Nueva Mesa creada exitosamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoMesas1 dtomesas1) {
        if (!sMesas1.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if (sMesas1.existByNumeroMesa(dtomesas1.getNumeroMesa()) && sMesas1.
                getByNumeroMesa(dtomesas1.getNumeroMesa()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Campo existente"), HttpStatus.BAD_REQUEST);
        }
        
        Mesas1 mesas1 = sMesas1.getOne(id).get();
        
        mesas1.setEstado(dtomesas1.getEstado());
        mesas1.setComanda(dtomesas1.getComanda());
        mesas1.setCierre(dtomesas1.getCierre());
        mesas1.setLiquidada(dtomesas1.getLiquidada());
        mesas1.setImagen(dtomesas1.getImagen());
        mesas1.setNumeroMesa(dtomesas1.getNumeroMesa());
        mesas1.setTotalComanda(dtomesas1.getTotalComanda());
        mesas1.setComensales(dtomesas1.getComensales());
        mesas1.setImpresion(dtomesas1.getImpresion());
        mesas1.setX(dtomesas1.getX());
        mesas1.setY(dtomesas1.getY());
        mesas1.setRotacion(dtomesas1.getRotacion());
        mesas1.setMesero(dtomesas1.getMesero());
        
        sMesas1.save(mesas1);
        
        return new ResponseEntity(new Mensaje("Mesa actualizada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/updateAll")
    public ResponseEntity<?> actualizarPosiciones(@RequestBody List<Mesas1> nuevasPosiciones) {
        sMesas1.actualizarPosiciones(nuevasPosiciones);
        return ResponseEntity.ok().build();
    }
}
