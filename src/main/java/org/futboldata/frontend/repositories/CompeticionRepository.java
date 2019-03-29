package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Asociacion;
import org.futboldata.frontend.domain.Competicion;
import org.springframework.data.repository.CrudRepository;

public interface CompeticionRepository extends CrudRepository<Competicion, Integer> {

    Iterable<Competicion> findAllByAsociacion(Asociacion asociacion);
}
