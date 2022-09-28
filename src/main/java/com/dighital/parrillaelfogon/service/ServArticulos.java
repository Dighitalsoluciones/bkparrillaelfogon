
package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.Articulos;
import com.dighital.parrillaelfogon.repository.RepArticulos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServArticulos {
    @Autowired
    RepArticulos rArticulos;
    
    public List<Articulos> list(){
        return rArticulos.findAll();
    }
 
    public Optional<Articulos> getOne(int id){
        return rArticulos.findById(id);
    }
    
    public Optional<Articulos> getByNombre(String nombre){
        return rArticulos.findByNombre(nombre);
    }
    
    public void save(Articulos articulos){
        rArticulos.save(articulos);
    }
    
    public void delete(int id){
        rArticulos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rArticulos.existsById(id);
    }
    
    public boolean existByNombre(String nombre){
        return rArticulos.existsByNombre(nombre);
    }
}


