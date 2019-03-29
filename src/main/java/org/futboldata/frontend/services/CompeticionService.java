package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Asociacion;
import org.futboldata.frontend.domain.Competicion;

public interface CompeticionService {

    Iterable<Competicion> list();

    Iterable<Competicion> listByAsociacion(Asociacion asociacion);
}
