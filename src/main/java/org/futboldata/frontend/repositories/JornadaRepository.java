package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JornadaRepository extends CrudRepository<Jornada, Integer> {

    Optional<Jornada> findById(Integer id);

    Iterable<Jornada> findAllByGrupo(Grupo grupo);
}
