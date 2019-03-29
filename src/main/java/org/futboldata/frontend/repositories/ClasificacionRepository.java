package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Clasificacion;
import org.springframework.data.repository.CrudRepository;

public interface ClasificacionRepository extends CrudRepository<Clasificacion, Integer>, ClasificacionCustomRepository {
}
