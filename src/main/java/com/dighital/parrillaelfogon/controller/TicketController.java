
package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoTicket;
import com.dighital.parrillaelfogon.entity.Ticket;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServTicket;
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
@RequestMapping("/ticket")
@CrossOrigin(origins = "https://parrielfogon.web.app")
public class TicketController {
    
    @Autowired
    ServTicket sTicket;
    
     @GetMapping("/lista")
    public ResponseEntity<List<Ticket>> list() {
        List<Ticket> list = sTicket.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Ticket> geyById(@PathVariable("id") int id){
        if(!sTicket.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Ticket ticket = sTicket.getOne(id).get();
        return new ResponseEntity(ticket ,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sTicket.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sTicket.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTicket dtoticket) {
        
        Ticket ticket = new Ticket(
                dtoticket.getListadoArticulos(), dtoticket.getImporte(),
                dtoticket.getObservacion(), dtoticket.getFecha(),
                dtoticket.getNumerodeMesa(), dtoticket.getFormadepago(),
                dtoticket.getCheckEd());
        sTicket.save(ticket);
        return new ResponseEntity(new Mensaje("Nueva Mesa creada exitosamente"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTicket dtoticket){
        if(!sTicket.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sTicket.existByObservacion(dtoticket.getObservacion()) && sTicket.
                getByFecha(dtoticket.getFecha()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Campo existente"), HttpStatus.BAD_REQUEST);
    }
               
        Ticket ticket = sTicket.getOne(id).get();
        
        ticket.setListadoArticulos(dtoticket.getListadoArticulos());
        ticket.setImporte(dtoticket.getImporte());
        ticket.setObservacion(dtoticket.getObservacion());
        ticket.setFecha(dtoticket.getFecha());
        ticket.setNumerodeMesa(dtoticket.getNumerodeMesa());
        ticket.setFormadepago(dtoticket.getFormadepago());
        ticket.setCheckEd(dtoticket.getCheckEd());

        sTicket.save(ticket);
        
        return new ResponseEntity(new Mensaje("Mesa actualizada correctamente"), HttpStatus.OK);
    }
}
