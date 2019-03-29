package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Asociacion;
import org.futboldata.frontend.domain.Competicion;
import org.futboldata.frontend.repositories.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompeticionServiceImpl implements CompeticionService {

    @Autowired
    private CompeticionRepository repository;

    @Override
    public Iterable<Competicion> list() {
        return repository.findAll();
    }

    @Override
    public Iterable<Competicion> listByAsociacion(Asociacion asociacion) {
        return repository.findAllByAsociacion(asociacion);
    }
}
