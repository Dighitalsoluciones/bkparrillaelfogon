package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.ObjetosMapa;
import com.dighital.parrillaelfogon.repository.RepObjetosMapa;
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
public class ServObjetosMapa {

    @Autowired
    RepObjetosMapa repObjetosMapa;

    public List<ObjetosMapa> list() {
        return repObjetosMapa.findAll();
    }

    public Optional<ObjetosMapa> getOne(Long id) {
        return repObjetosMapa.findById(id);
    }

    public void save(ObjetosMapa objetosMapa) {
        repObjetosMapa.save(objetosMapa);
    }

    public void delete(Long id) {
        repObjetosMapa.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repObjetosMapa.existsById(id);
    }

    public void actualizarPosiciones(List<ObjetosMapa> nuevasPosiciones) {
        // Puedes implementar la lógica para actualizar las posiciones de las mesas aquí
        // Por ejemplo:
        for (ObjetosMapa objetosMapa : nuevasPosiciones) {
            ObjetosMapa objetoExistente = repObjetosMapa.findById(objetosMapa.getId()).orElse(null);
            if (objetoExistente != null) {
                objetoExistente.setX(objetosMapa.getX());
                objetoExistente.setY(objetosMapa.getY());
                repObjetosMapa.save(objetoExistente);
            }
        }
    }

}
