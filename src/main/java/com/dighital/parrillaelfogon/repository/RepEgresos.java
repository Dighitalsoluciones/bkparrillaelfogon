
package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.Egresos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepEgresos extends  JpaRepository<Egresos, Integer> {
    public Optional<Egresos> findByFecha(String fecha);
    public boolean existsByMostrar(String mostrar);
}
