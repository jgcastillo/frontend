package org.futboldata.frontend.repositories;

import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;

public interface ClasificacionCustomRepository {

    Iterable<Object> listByGrupoJornada(Grupo grupo, Jornada jornada);
}
