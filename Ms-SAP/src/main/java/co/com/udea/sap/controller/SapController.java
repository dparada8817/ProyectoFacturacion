package co.com.udea.sap.controller;

import co.com.udea.sap.modelo.Factura;
import co.com.udea.sap.servicio.SapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SapController {
    @Autowired
    SapService SapService;

    @RequestMapping(value = "/facturas",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Factura>> buscarSerie(){
        List<Factura> facturas = SapService.getFacturas();
        return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
    };
}
