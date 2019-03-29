package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Clasificacion;
import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.repositories.ClasificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasificacionServiceImpl implements ClasificacionService{

    @Autowired
    private ClasificacionRepository repository;

    @Override
    public Iterable<Object> listByGrupoJornada(Grupo grupo, Jornada jornada) {
        return repository.listByGrupoJornada(grupo, jornada);
    }
}
