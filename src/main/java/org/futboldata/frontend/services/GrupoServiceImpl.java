package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    private GrupoRepository repository;

    @Override
    public Optional<Grupo> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Grupo> list(Fase fase) {
        return repository.findAllByFase(fase);
    }
}
