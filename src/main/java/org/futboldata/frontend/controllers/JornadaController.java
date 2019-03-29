package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.domain.Jornada;
import org.futboldata.frontend.exceptions.ResourceNotFoundException;
import org.futboldata.frontend.services.JornadaService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Sistema de Entrega de Jornadass", description= "Operaciones pertinentes del Sistema de Entrega de Jornadas")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class JornadaController {

    @Autowired
    private JornadaService service;

    @ApiOperation(value = "Busca una Jornada por su Id", response = Jornada.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la Fase con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("jornada/{id}")
    public ResponseEntity<Jornada> findById(
            @ApiParam(value="id de la Jornada que se desea obtener", required = true)
            @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Optional<Jornada> opt = service.findById(id);

        if(opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Jornada no encontrada para el id: " + id);
        }
    }

    @ApiOperation(value = "Busca la lista de Jornadas en un Grupo", response = Jornada.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/jornadas/{id}")
    public ResponseEntity<Iterable<Jornada>> list(
            @ApiParam(value = "Id del Grupo del que se desean las Jornadas", required = true)
            @PathVariable Integer id){

        Grupo grupo = new Grupo(id);
        Iterable<Jornada> lista = service.list(grupo);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
