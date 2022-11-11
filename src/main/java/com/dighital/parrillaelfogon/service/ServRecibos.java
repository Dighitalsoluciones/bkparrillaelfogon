
package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.Recibos;
import com.dighital.parrillaelfogon.repository.RepRecibos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServRecibos {
    @Autowired
    RepRecibos rRecibos;

    public List<Recibos> list() {
        return rRecibos.findAll();
    }

    public Optional<Recibos> getOne(int id) {
        return rRecibos.findById(id);
    }

    public Optional<Recibos> getByFecha(String fecha) {
        return rRecibos.findByFecha(fecha);
    }

    public void save(Recibos recibos) {
        rRecibos.save(recibos);
    }

    public void delete(int id) {
        rRecibos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rRecibos.existsById(id);
    }

    public boolean existByCorresTicket(String corresTicket) {
        return rRecibos.existsByImporte(corresTicket);
    }

}
