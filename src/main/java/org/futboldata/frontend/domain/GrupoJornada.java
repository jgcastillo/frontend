package org.futboldata.frontend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrupoJornada {

    private Grupo grupo;
    private Jornada jornada;
}
