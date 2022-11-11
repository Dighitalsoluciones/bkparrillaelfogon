
package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoRecibos;
import com.dighital.parrillaelfogon.entity.Recibos;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServRecibos;
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
@RequestMapping("/recibos")
@CrossOrigin(origins = "http://localhost:4200")
public class RecibosController {
    @Autowired
    ServRecibos sRecibos;
    
     @GetMapping("/lista")
    public ResponseEntity<List<Recibos>> list() {
        List<Recibos> list = sRecibos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Recibos> geyById(@PathVariable("id") int id){
        if(!sRecibos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Recibos recibos = sRecibos.getOne(id).get();
        return new ResponseEntity(recibos ,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sRecibos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sRecibos.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRecibos dtorecibos) {
        
        Recibos recibos = new Recibos(
                dtorecibos.getFecha(), dtorecibos.getCorresTicket(), dtorecibos.getImporte(), dtorecibos.getObservacion(),dtorecibos.getNumerodeMesa(), dtorecibos.getFormadepago());
        sRecibos.save(recibos);
        return new ResponseEntity(new Mensaje("Nuevo recibo creado exitosamente"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoRecibos dtorecibos){
        if(!sRecibos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sRecibos.existByCorresTicket(dtorecibos.getCorresTicket()) && sRecibos.
                getByFecha(dtorecibos.getFecha()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Campo existente"), HttpStatus.BAD_REQUEST);
    }
               
        Recibos recibos = sRecibos.getOne(id).get();
        
        recibos.setFecha(dtorecibos.getFecha());
        recibos.setCorresTicket(dtorecibos.getCorresTicket());
        recibos.setImporte(dtorecibos.getImporte());
        recibos.setObservacion(dtorecibos.getObservacion());
        recibos.setNumerodeMesa(dtorecibos.getNumerodeMesa());
        recibos.setFormadepago(dtorecibos.getFormadepago());
        
       
               
        sRecibos.save(recibos);
        
        return new ResponseEntity(new Mensaje("Mesa actualizada correctamente"), HttpStatus.OK);
    }
}
