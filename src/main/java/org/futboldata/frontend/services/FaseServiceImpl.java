package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Temporada;
import org.futboldata.frontend.repositories.FaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FaseServiceImpl implements FaseService{

    @Autowired
    private FaseRepository repository;

    @Override
    public Optional<Fase> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Fase> listByTemporada(Temporada temporada) {
        return repository.findAllByTemporada(temporada);
    }

}
