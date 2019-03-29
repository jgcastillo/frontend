package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Grupo;

import java.util.Optional;

public interface GrupoService {

    Optional<Grupo> findById(Integer id);

    Iterable<Grupo> list(Fase fase);
}
