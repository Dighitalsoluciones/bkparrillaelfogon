
package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.Recibos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepRecibos extends JpaRepository<Recibos, Integer>{
    public Optional<Recibos> findByFecha(String fecha);
    public boolean existsByImporte(String importe);
}

