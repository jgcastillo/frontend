package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Competicion;
import org.futboldata.frontend.domain.Temporada;
import org.springframework.data.repository.CrudRepository;

public interface TemporadaRepository extends CrudRepository<Temporada, Integer> {

    public Iterable<Temporada> findAllByCompeticion(Competicion competicion);
}
