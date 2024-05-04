package com.dighital.parrillaelfogon.controller;

import com.dighital.parrillaelfogon.dto.dtoMovimientoStock;
import com.dighital.parrillaelfogon.entity.MovimientoStock;
import com.dighital.parrillaelfogon.security.controller.Mensaje;
import com.dighital.parrillaelfogon.service.ServMovimientoStock;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:4200")
public class MovimientoStockController {

    @Autowired()
    ServMovimientoStock serviceMovimientoStock;

    @GetMapping("/lista")
    public ResponseEntity<List<MovimientoStock>> list() {
        List<MovimientoStock> list = serviceMovimientoStock.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<MovimientoStock> geyById(@PathVariable("id") Long id) {
        if (!serviceMovimientoStock.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.BAD_REQUEST);
        }
        MovimientoStock movimientoStock = serviceMovimientoStock.getOne(id).get();
        return new ResponseEntity(movimientoStock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!serviceMovimientoStock.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id Inexistente"), HttpStatus.NOT_FOUND);
        }
        serviceMovimientoStock.delete(id);
        return new ResponseEntity(new Mensaje("Objeto eliminado correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoMovimientoStock dtomovimientoStock) {

        MovimientoStock movimientoStock = new MovimientoStock(
                dtomovimientoStock.getListadoItem(), dtomovimientoStock.getFecha(),
                dtomovimientoStock.getObservacion());

        serviceMovimientoStock.save(movimientoStock);
        return new ResponseEntity(new Mensaje("Nuevo objeto creado exitosamente"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoMovimientoStock dtomovimientoStock) {
        if (!serviceMovimientoStock.existsById(id)) {
            return new ResponseEntity(new Mensaje("Id inexistente"), HttpStatus.NOT_FOUND);
        }

        if (StringUtils.isBlank(dtomovimientoStock.getListadoItem())) {
            return new ResponseEntity(new Mensaje("El listado no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        MovimientoStock movimientoStock = serviceMovimientoStock.getOne(id).get();

        movimientoStock.setListadoItem(dtomovimientoStock.getListadoItem());
        movimientoStock.setFecha(dtomovimientoStock.getFecha());
        movimientoStock.setObservacion(dtomovimientoStock.getObservacion());

        serviceMovimientoStock.save(movimientoStock);

        return new ResponseEntity(new Mensaje("Objeto actualizado correctamente"), HttpStatus.OK);
    }

    /**
     * Instancia de entityManager, para realizar consultas directas en la bd
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Metodo para obtener el id del proximo movimientoStock a crearse, para
     * mostrar en el FrontEnd.
     *
     * @return
     */
    @GetMapping("/nextId")
    public ResponseEntity<Long> getNextId() {
        String sql = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'bkparrielfogon' AND TABLE_NAME = 'movimiento_stock'";
        Query query = entityManager.createNativeQuery(sql);
        Long nextId = ((BigInteger) query.getSingleResult()).longValue();
        return ResponseEntity.ok(nextId);
    }

}
