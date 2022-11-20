
package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.Egresos;
import com.dighital.parrillaelfogon.repository.RepEgresos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServEgresos {
    @Autowired
    RepEgresos rEgresos;
    
    public List<Egresos> list() {
        return rEgresos.findAll();
    }

    public Optional<Egresos> getOne(int id) {
        return rEgresos.findById(id);
    }

    public Optional<Egresos> getByFecha(String fecha) {
        return rEgresos.findByFecha(fecha);
    }

    public void save(Egresos egresos) {
        rEgresos.save(egresos);
    }

    public void delete(int id) {
        rEgresos.deleteById(id);
    }

    public boolean existsById(int id) {
        return rEgresos.existsById(id);
    }

    public boolean existByMostrar(String mostrar) {
        return rEgresos.existsByMostrar(mostrar);
    }

    
}
