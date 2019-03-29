package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import lombok.Data;
import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Grupo;
import org.futboldata.frontend.exceptions.ResourceNotFoundException;
import org.futboldata.frontend.services.GrupoService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Sistema de Entrega de Grupos", description= "Operaciones pertinentes del Sistema de Entrega de Grupos")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class GrupoController {

    @Autowired
    private GrupoService service;

    @ApiOperation(value = "Busca un Grupo por su Id", response = Grupo.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la Fase con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("grupo/{id}")
    public ResponseEntity<Grupo> findById(
            @ApiParam(value = "Id del Grupo que se desea obtener", required = true)
            @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        Optional<Grupo> opt = service.findById(id);
        if(opt.isPresent()){
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Grupo no encontrado para el id: " + id);
        }
    }

    @ApiOperation(value = "Busca la lista de Grupos en una Fase", response = Grupo.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/grupos/{id}")
    public ResponseEntity<Iterable<Grupo>> list(
            @ApiParam(value = "Id de la Fase de la que se desean los Grupos", required = true)
            @PathVariable Integer id){
        Fase fase = new Fase(id);
        Iterable<Grupo> lista = service.list(fase);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
