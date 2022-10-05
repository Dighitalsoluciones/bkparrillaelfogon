package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.Mesas1;
import com.dighital.parrillaelfogon.repository.RepMesa1;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServMesa1 {

    @Autowired
    RepMesa1 rMesas1;

    public List<Mesas1> list() {
        return rMesas1.findAll();
    }

    public Optional<Mesas1> getOne(int id) {
        return rMesas1.findById(id);
    }

    public Optional<Mesas1> getByNumeroMesa(String numeromesa) {
        return rMesas1.findByNumeroMesa(numeromesa);
    }

    public void save(Mesas1 mesas1) {
        rMesas1.save(mesas1);
    }

    public void delete(int id) {
        rMesas1.deleteById(id);
    }

    public boolean existsById(int id) {
        return rMesas1.existsById(id);
    }

    public boolean existByNumeroMesa(String numeromesa) {
        return rMesas1.existsByNumeroMesa(numeromesa);
    }
}
