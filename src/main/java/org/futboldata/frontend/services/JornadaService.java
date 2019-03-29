package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;

import java.util.Optional;

public interface JornadaService {

    Optional<Jornada> findById(Integer id);

    Iterable<Jornada> list(Grupo grupo);
}
