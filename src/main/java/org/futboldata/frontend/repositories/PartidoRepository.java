package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.domain.Llave;
import org.futboldata.frontend.domain.Partido;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PartidoRepository extends CrudRepository<Partido, Integer> {

    Optional<Partido> findById(Integer id);

    Iterable<Partido> findAllByJornada(Jornada jornada);

    Iterable<Partido> findAllByLlave(Llave llave);
}
