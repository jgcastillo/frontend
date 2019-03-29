package org.futboldata.frontend.controllers;

import io.swagger.annotations.*;
import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.domain.Llave;
import org.futboldata.frontend.exceptions.ResourceNotFoundException;
import org.futboldata.frontend.services.LlaveService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Api(value = "Sistema de Entrega de Llaves", description= "Operaciones pertinentes del Sistema de Entrega de Llaves")
@RestController
@RequestMapping(Constants.API_ADDRESS)
public class LlaveController {

    @Autowired
    private LlaveService service;

    @ApiOperation(value = "Busca una Llave por su Id", response = Llave.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenido la Llave con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/llave/{id}")
    public ResponseEntity<Llave> findById(
            @ApiParam(value="id de la Llave que se desea obtener", required = true)
            @PathVariable(value = "id") Integer id) throws ResourceNotFoundException {

        Optional<Llave> opt = service.findById(id);

        if(opt.isPresent()){
            return new ResponseEntity<Llave>(opt.get(), HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Llave no encontrada para el id: " + id);
        }
    }

    @ApiOperation(value = "Busca la lista de Llaves en una Fase", response = Llave.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/llaves/{id}")
    public ResponseEntity<Iterable<Llave>> list(
            @ApiParam(value="id de la Fase en que se desean obtener las Llaves", required = true)
            @PathVariable(value = "id") Integer id ){
        Fase fase = new Fase(id);
        Iterable<Llave> lista =  service.list(fase);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
