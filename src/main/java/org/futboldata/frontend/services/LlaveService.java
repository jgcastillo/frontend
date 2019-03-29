package org.futboldata.frontend.services;

import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Llave;

import java.util.Optional;

public interface LlaveService {

    Optional<Llave> findById(Integer id);

    Iterable<Llave> list(Fase fase);
}
