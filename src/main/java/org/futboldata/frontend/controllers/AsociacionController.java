package org.futboldata.frontend.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.futboldata.frontend.domain.Asociacion;
import org.futboldata.frontend.domain.Fase;
import org.futboldata.frontend.services.AsociacionService;
import org.futboldata.frontend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Sistema de Entrega de Asociaciones", description= "Operaciones pertinentes del Sistema de Entrega de Asociaciones")
@RestController
@RequestMapping(path= Constants.API_ADDRESS)
public class AsociacionController {

    @Autowired
    private AsociacionService service;

    @ApiOperation(value = "Busca la lista total de Asociaciones", response = Asociacion.class)
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Obtenida la lista con éxito"),
            @ApiResponse(code = 401, message = "No tiene autorización para ver el recurso"),
            @ApiResponse(code = 403, message = "No tiene permitido el acceso a este recurso"),
            @ApiResponse(code = 404, message = "El recurso solicitado no se ha encontrado")
    })
    @GetMapping("/asociaciones")
    public ResponseEntity<Iterable<Asociacion>> asociaciones(){
        return new ResponseEntity<>(service.list(), HttpStatus.OK);
    }
}
