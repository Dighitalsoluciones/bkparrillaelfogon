
package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.Mesas1;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepMesa1 extends JpaRepository<Mesas1, Integer> {
    public Optional<Mesas1> findByEstado(String estado);
    public boolean existsByEstado(String estado);
    
}
