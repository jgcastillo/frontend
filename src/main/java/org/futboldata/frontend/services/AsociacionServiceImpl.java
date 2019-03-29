package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Asociacion;
import org.futboldata.frontend.repositories.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsociacionServiceImpl implements AsociacionService {

    @Autowired
    private AsociacionRepository repository;

    @Override
    public Iterable<Asociacion> list() {
        return repository.findAll();
    }
}
