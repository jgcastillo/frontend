package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.repositories.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JornadaServiceImpl implements JornadaService {

    @Autowired
    private JornadaRepository repository;

    @Override
    public Optional<Jornada> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Jornada> list(Grupo grupo) {
        return repository.findAllByGrupo(grupo);
    }
}
