package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Competicion;
import org.futboldata.frontend.domain.Temporada;

import java.util.Optional;

public interface TemporadaService {

    Optional<Temporada> findById(Integer id);

    Iterable<Temporada> list(Competicion competicion);
}
