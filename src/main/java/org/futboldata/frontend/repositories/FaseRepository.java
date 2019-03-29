package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Temporada;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FaseRepository extends CrudRepository<Fase, Integer> {

    Optional<Fase> findById(Integer id);

    Iterable<Fase> findAllByTemporada(Temporada temporada);
}
