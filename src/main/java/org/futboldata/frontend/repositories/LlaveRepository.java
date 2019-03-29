package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Llave;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LlaveRepository extends CrudRepository<Llave, Integer> {

    Optional<Llave> findById(Integer id);

    Iterable<Llave> findAllByFase(Fase fase);
}
