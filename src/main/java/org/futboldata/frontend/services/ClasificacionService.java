package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;

public interface ClasificacionService {

    Iterable<Object> listByGrupoJornada(Grupo grupo, Jornada jornada);
}
