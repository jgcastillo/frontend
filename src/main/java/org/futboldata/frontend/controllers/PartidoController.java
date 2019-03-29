package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.domain.Llave;
import org.futboldata.frontend.domain.Partido;
import org.futboldata.frontend.exceptions.ResourceNotFoundException;
import org.futboldata.frontend.services.PartidoService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Sistema de Entrega de Partidos", description= "Operaciones pertinentes del Sistema de Entrega de Partidos")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class PartidoController {

    @Autowired
    private PartidoService service;

    @ApiOperation(value = "Busca un Partido por su Id", response = Partido.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenido el Partido con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/partido/{id}")
    public ResponseEntity<Partido> findById(
            @ApiParam(value="id del Partido que se desea obtener", required = true)
            @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        Optional<Partido> opt = service.findById(id);

        if(opt.isPresent()){
            return new ResponseEntity<Partido>(opt.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Partido no encontrado para el id: " + id);
        }
    }

    @ApiOperation(value = "Busca la lista de Partidos en una Jornada", response = Partido.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("partidosjornada/{id}")
    public ResponseEntity<Iterable<Partido>> listByJornada(
            @ApiParam(value = "Id de la Jornada del que se desean los Partidos", required = true)
            @PathVariable(value = "id") Integer id){

        Jornada jornada = new Jornada(id);
        Iterable<Partido> lista = service.listByJornada(jornada);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Busca la lista de Partidos en una Llave", response = Partido.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("partidosllave/{id}")
    public ResponseEntity<Iterable<Partido>> listByLlave(
            @ApiParam(value = "Id de la Llave del que se desean los Partidos", required = true)
            @PathVariable(value = "id") Integer id ){

        Llave llave = new Llave(id);
        Iterable<Partido> lista = service.listByLlave(llave);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
