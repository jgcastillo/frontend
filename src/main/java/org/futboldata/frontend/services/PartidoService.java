package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.domain.Llave;
import org.futboldata.frontend.domain.Partido;

import java.util.Optional;

public interface PartidoService {

    Optional<Partido> findById(Integer id);

    Iterable<Partido> listByJornada(Jornada jornada);

    Iterable<Partido> listByLlave(Llave llave);
}
