package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Clasificacion;
import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.GrupoJornada;
import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.services.ClasificacionService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Sistema de Entrega de Clasificaciones",
        description= "Operaciones pertinentes del Sistema de Entrega de Clasificaciones")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class ClasificacionController {

    @Autowired
    private ClasificacionService service;

    @ApiOperation(value = "Lista la Clasificacion de una Jornada", response = Clasificacion.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la Clasificacion con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/clasificacion/{grupoId}/{jornadaId}")
    public ResponseEntity<Iterable<Object>> listByGrupoJornada(
            @ApiParam(value = "Id del Grupo del que se desea la Clasificacion", required = true)
            @PathVariable(value = "grupoId") Integer grupoId,
            @ApiParam(value = "Id de la Jornada de la que se desea la Clasificacion", required = true)
            @PathVariable(value = "jornadaId") Integer jornadaId){

        Grupo grupo = new Grupo(grupoId);
        Jornada jornada = new Jornada(jornadaId);

        Iterable<Object> lista = service.listByGrupoJornada(grupo, jornada);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
