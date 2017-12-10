package co.com.udea.facturacion.msbi.controller;

import co.com.udea.facturacion.msbi.modelo.Factura;
import co.com.udea.facturacion.msbi.servicio.ServicioFacturas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DavidAlexander on 08/12/2017.
 */
@RestController
public class BIController {

    @Autowired
    ServicioFacturas servicioFacturas;

    @RequestMapping(value = "/facturas",produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Factura>> buscarFacturas(){
        List<Factura> facturas = servicioFacturas.getFacturas();
        return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
    };
}
