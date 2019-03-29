package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.domain.Llave;
import org.futboldata.frontend.domain.Partido;
import org.futboldata.frontend.repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartidoServiceImpl implements PartidoService {

    @Autowired
    private PartidoRepository repository;

    @Override
    public Optional<Partido> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Partido> listByJornada(Jornada jornada) {
        return repository.findAllByJornada(jornada);
    }

    @Override
    public Iterable<Partido> listByLlave(Llave llave) {
        return repository.findAllByLlave(llave);
    }
}
