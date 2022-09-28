
package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.Articulos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepArticulos extends JpaRepository<Articulos, Integer>{
    public Optional<Articulos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
