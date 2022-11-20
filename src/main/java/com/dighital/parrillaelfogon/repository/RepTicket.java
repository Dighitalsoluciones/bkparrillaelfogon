
package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.Ticket;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepTicket extends JpaRepository<Ticket, Integer>{
    public Optional<Ticket> findByFecha(String fecha);
    public boolean existsByObservacion(String observacion);
}
