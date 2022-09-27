
package com.dighital.parrillaelfogon.security.repository;

import com.dighital.parrillaelfogon.security.entity.Rol;
import com.dighital.parrillaelfogon.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
