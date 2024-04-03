package com.dighital.parrillaelfogon.repository;

import com.dighital.parrillaelfogon.entity.ObjetosMapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface RepObjetosMapa extends JpaRepository<ObjetosMapa, Long> {

}
