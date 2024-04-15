package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hag
 */
@Repository
public interface RepEmpleado extends JpaRepository<Empleado, Long> {

}
