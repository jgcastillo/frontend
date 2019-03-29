package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Temporada;
import org.futboldata.frontend.exceptions.ResourceNotFoundException;
import org.futboldata.frontend.services.FaseService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Sistema de Entrega de Fases", description= "Operaciones pertinentes del Sistema de Entrega de Fases")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class FaseController {

    @Autowired
    private FaseService service;

    @ApiOperation(value = "Busca una Fase por su Id", response = Fase.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la Fase con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("fase/{id}")
    public ResponseEntity<Fase> findById(
            @ApiParam(value = "Id de la Fase que se desa obtener", required = true)
            @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        Optional<Fase> opt = service.findById(id);
        if(opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Fase no encontrada para el id: " + id);
        }
    }

    @ApiOperation(value = "Busca la lista de Fases en una Temporada", response = Fase.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/fases/{id}")
    public ResponseEntity<Iterable<Fase>> list(
            @ApiParam(value = "Id de la Temporada de la que se desean las Fases", required = true)
            @PathVariable Integer id){
        Temporada temporada = new Temporada(id);
        Iterable<Fase> lista = service.listByTemporada(temporada);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
