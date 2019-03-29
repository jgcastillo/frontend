package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Temporada;

import java.util.Optional;

public interface FaseService {

    Optional<Fase> findById(Integer id);

    Iterable<Fase> listByTemporada(Temporada temporada);
}
