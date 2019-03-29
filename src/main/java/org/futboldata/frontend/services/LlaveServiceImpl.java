package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Llave;
import org.futboldata.frontend.repositories.LlaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LlaveServiceImpl implements LlaveService {

    @Autowired
    private LlaveRepository repository;

    @Override
    public Optional<Llave> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Llave> list(Fase fase) {
        return repository.findAllByFase(fase);
    }
}
