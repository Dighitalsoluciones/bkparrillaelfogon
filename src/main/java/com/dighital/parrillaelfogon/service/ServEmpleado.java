package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.Empleado;
import com.dighital.parrillaelfogon.repository.RepEmpleado;
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
public class ServEmpleado {

    @Autowired
    RepEmpleado repositoryEmpleado;

    public List<Empleado> list() {
        return repositoryEmpleado.findAll();
    }

    public Optional<Empleado> getOne(Long id) {
        return repositoryEmpleado.findById(id);
    }

    public void save(Empleado empleado) {
        repositoryEmpleado.save(empleado);
    }

    public void delete(Long id) {
        repositoryEmpleado.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repositoryEmpleado.existsById(id);
    }

}
