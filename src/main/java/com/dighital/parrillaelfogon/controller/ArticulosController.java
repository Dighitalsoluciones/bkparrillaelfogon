
package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoArticulos;
import com.dighital.parrillaelfogon.entity.Articulos;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServArticulos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/articulos")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticulosController {
    
    @Autowired()
    ServArticulos sArticulos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Articulos>> list() {
        List<Articulos> list = sArticulos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Articulos> geyById(@PathVariable("id") int id){
        if(!sArticulos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        Articulos articulos = sArticulos.getOne(id).get();
        return new ResponseEntity(articulos, HttpStatus.OK);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sArticulos.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        sArticulos.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoArticulos dtoarticulos) {
        if (StringUtils.isBlank(dtoarticulos.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(dtoarticulos.getFamilia())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoarticulos.getStock())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoarticulos.getPuntorepo())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoarticulos.getCosto())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoarticulos.getPrecioventa())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoarticulos.getStockinicial())) {
            return new ResponseEntity(new Mensaje("Campo Obligatorio"), HttpStatus.BAD_REQUEST);
        }
   
        
        if (sArticulos.existByNombre(dtoarticulos.getNombre())) {
            return new ResponseEntity(new Mensaje("Nombre ya existente"), HttpStatus.BAD_REQUEST);
        }

        Articulos articulos = new Articulos(
                dtoarticulos.getNombre(), dtoarticulos.getFamilia(), dtoarticulos.getStock(), dtoarticulos.getPuntorepo(), dtoarticulos.getCosto(), dtoarticulos.getPrecioventa(),
                dtoarticulos.getStockinicial(), dtoarticulos.getImagen());
        sArticulos.save(articulos);
        return new ResponseEntity(new Mensaje("Nuevo objeto creado exitosamente"), HttpStatus.OK);
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoArticulos dtoarticulos){
        if(!sArticulos.existsById(id)){
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }
        if(sArticulos.existByNombre(dtoarticulos.getNombre()) && sArticulos.
                getByNombre(dtoarticulos.getNombre()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Nombre existente"), HttpStatus.BAD_REQUEST);
    }
        if(StringUtils.isBlank(dtoarticulos.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoarticulos.getFamilia())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoarticulos.getStock())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoarticulos.getPuntorepo())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoarticulos.getCosto())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoarticulos.getPrecioventa())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoarticulos.getStockinicial())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        
        
        
        Articulos articulos = sArticulos.getOne(id).get();
        
        articulos.setNombre(dtoarticulos.getNombre());
        articulos.setFamilia(dtoarticulos.getFamilia());
        articulos.setStock(dtoarticulos.getStock());
        articulos.setPuntorepo(dtoarticulos.getPuntorepo());
        articulos.setCosto(dtoarticulos.getCosto());
        articulos.setPrecioventa(dtoarticulos.getPrecioventa());
        articulos.setStockinicial(dtoarticulos.getStockinicial());
        articulos.setImagen (dtoarticulos.getImagen());
               
        sArticulos.save(articulos);
        
        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }
}
