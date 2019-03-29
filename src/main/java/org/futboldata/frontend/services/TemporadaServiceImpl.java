package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Competicion;
import org.futboldata.frontend.domain.Temporada;
import org.futboldata.frontend.repositories.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TemporadaServiceImpl implements TemporadaService{

    @Autowired
    private TemporadaRepository repository;

    @Override
    public Optional<Temporada> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Temporada> list(Competicion competicion) {
        return repository.findAllByCompeticion(competicion);
    }
}
