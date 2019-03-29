package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Competicion;
import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Temporada;
import org.futboldata.frontend.exceptions.ResourceNotFoundException;
import org.futboldata.frontend.services.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Sistema de Entrega de Temporadas", description= "Operaciones pertinentes del Sistema de Entrega de Temporadas")
@RestController
@RequestMapping("/fdapi")
public class TemporadaController {

    @Autowired
    private TemporadaService service;

    @ApiOperation(value = "Busca una Temporada por su Id", response = Temporada.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la Temporada con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/temporada/{id}")
    public ResponseEntity<Temporada> getTemporada(
            @ApiParam(value = "Id de la Temporada que se desea obtener", required = true)
            @PathVariable int id) throws ResourceNotFoundException {

        Optional<Temporada> opt = service.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Temporada no encontrada para el id: " + id);
        }
    }

    @ApiOperation(value = "Busca la lista de Temporadas en una Competición", response = Temporada.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping ("/temporadas/{competicionId}")
    public ResponseEntity<Iterable<Temporada>> listByCompeticion(
            @ApiParam(value = "Id de la Competicion de la que se desean las Temporadas", required = true)
            @PathVariable int competicionId){
        Competicion competicion = new Competicion(competicionId);
        Iterable<Temporada> lista = service.list(competicion);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
