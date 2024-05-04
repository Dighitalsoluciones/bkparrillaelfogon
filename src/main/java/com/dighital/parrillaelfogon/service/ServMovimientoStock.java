package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.MovimientoStock;
import com.dighital.parrillaelfogon.repository.RepMovimientoStock;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hag
 */
@Service
@Transactional
public class ServMovimientoStock {

    @Autowired
    RepMovimientoStock repMovimientoStock;

    public List<MovimientoStock> list() {
        return repMovimientoStock.findAll();
    }

    public Optional<MovimientoStock> getOne(Long id) {
        return repMovimientoStock.findById(id);
    }

    public void save(MovimientoStock movimientoStock) {
        repMovimientoStock.save(movimientoStock);
    }

    public void delete(Long id) {
        repMovimientoStock.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repMovimientoStock.existsById(id);
    }

    public Optional<MovimientoStock> findById(Long id) {
        return repMovimientoStock.findById(id);
    }

}
