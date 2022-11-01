package com.dighital.parrillaelfogon.service;

import com.dighital.parrillaelfogon.entity.Ticket;
import com.dighital.parrillaelfogon.repository.RepTicket;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServTicket {

    @Autowired
    RepTicket rTicket;

    public List<Ticket> list() {
        return rTicket.findAll();
    }

    public Optional<Ticket> getOne(int id) {
        return rTicket.findById(id);
    }

    public Optional<Ticket> getByFecha(String fecha) {
        return rTicket.findByFecha(fecha);
    }

    public void save(Ticket ticket) {
        rTicket.save(ticket);
    }

    public void delete(int id) {
        rTicket.deleteById(id);
    }

    public boolean existsById(int id) {
        return rTicket.existsById(id);
    }

    public boolean existByImporte(String importe) {
        return rTicket.existsByImporte(importe);
    }

}
