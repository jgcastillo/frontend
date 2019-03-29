package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Grupo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GrupoRepository extends CrudRepository<Grupo, Integer> {

    Optional<Grupo> findById(Integer id);

    Iterable<Grupo> findAllByFase(Fase fase);
}
