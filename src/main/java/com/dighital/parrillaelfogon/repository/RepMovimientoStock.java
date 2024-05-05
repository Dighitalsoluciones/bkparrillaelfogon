package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.MovimientoStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HAG
 */
@Repository
public interface RepMovimientoStock extends JpaRepository<MovimientoStock, Long> {

}
