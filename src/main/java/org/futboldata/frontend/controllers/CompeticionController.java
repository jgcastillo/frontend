package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Asociacion;
import org.futboldata.frontend.domain.Competicion;
import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.services.CompeticionService;
import org.futboldata.frontend.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Sistema de Entrega de Competiciones",
        description= "Operaciones pertinentes del Sistema de Entrega de Competiciones")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class CompeticionController {

    @Autowired
    private CompeticionService service;

    @ApiOperation(value = "Busca la lista total Competiciones", response = Competicion.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/competiciones")
    public ResponseEntity<Iterable<Competicion>> list(){
        Iterable<Competicion> lista = service.list();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Busca la lista de Competiciones de una Asociación", response = Competicion.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/competiciones/{id}")
    public ResponseEntity<Iterable<Competicion>> listByAsociacion(
            @ApiParam(value = "Id de la Asociación de la que se desean las Competiciones", required = true) @PathVariable int id){
        Asociacion asociacion = new Asociacion(id);
        Iterable<Competicion> lista = service.listByAsociacion(asociacion);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
