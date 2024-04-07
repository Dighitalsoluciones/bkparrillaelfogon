package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoObjetosMapa;
import com.dighital.parrillaelfogon.entity.ObjetosMapa;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServObjetosMapa;
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

/**
 *
 * @author Hag
 */
@RestController
@RequestMapping("/objetosmapa")
@CrossOrigin(origins = "https://parrielfogon.web.app")
public class ObjetosMapaController {

    @Autowired
    ServObjetosMapa servObjetosMapa;

    @GetMapping("/lista")
    public ResponseEntity<List<ObjetosMapa>> list() {
        List<ObjetosMapa> list = servObjetosMapa.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ObjetosMapa> geyById(@PathVariable("id") Long id) {
        if (!servObjetosMapa.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        ObjetosMapa objetosMapa = servObjetosMapa.getOne(id).get();
        return new ResponseEntity(objetosMapa, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!servObjetosMapa.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        servObjetosMapa.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoObjetosMapa dtoObjetosMapa) {

        ObjetosMapa objetosMapa = new ObjetosMapa(
                dtoObjetosMapa.getImagen(), dtoObjetosMapa.getX(), dtoObjetosMapa.getY(), dtoObjetosMapa.getRotacion(),
                dtoObjetosMapa.getAncho(), dtoObjetosMapa.getLargo(), dtoObjetosMapa.getTexto(), dtoObjetosMapa.getColorText());
        servObjetosMapa.save(objetosMapa);
        return new ResponseEntity(new Mensaje("Nueva Objeto del mapa creadao exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoObjetosMapa dtoObjetosMapa) {
        if (!servObjetosMapa.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }

        ObjetosMapa objetosMapa = servObjetosMapa.getOne(id).get();

        objetosMapa.setImagen(dtoObjetosMapa.getImagen());
        objetosMapa.setX(dtoObjetosMapa.getX());
        objetosMapa.setY(dtoObjetosMapa.getY());
        objetosMapa.setRotacion(dtoObjetosMapa.getRotacion());
        objetosMapa.setAncho(dtoObjetosMapa.getAncho());
        objetosMapa.setLargo(dtoObjetosMapa.getLargo());
        objetosMapa.setTexto(dtoObjetosMapa.getTexto());
        objetosMapa.setColorText(dtoObjetosMapa.getColorText());

        servObjetosMapa.save(objetosMapa);

        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }

    @PutMapping("/updateAll")
    public ResponseEntity<?> actualizarPosiciones(@RequestBody List<ObjetosMapa> nuevasPosiciones) {
        servObjetosMapa.actualizarPosiciones(nuevasPosiciones);
        return ResponseEntity.ok().build();
    }

}
