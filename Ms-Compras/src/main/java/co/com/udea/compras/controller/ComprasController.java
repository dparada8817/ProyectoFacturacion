package co.com.udea.compras.controller;

import co.com.udea.compras.modelo.Cliente;
import co.com.udea.compras.modelo.Factura;
import co.com.udea.compras.servicio.ServicioClientes;
import co.com.udea.compras.servicio.ServicioFacturas;
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
public class ComprasController {

    @Autowired
    ServicioClientes servicioClientes;
    @Autowired
    ServicioFacturas servicioFacturas;

    @RequestMapping(value = "/clientes",produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Cliente>> buscarClientes(){
        List<Cliente> clientes = servicioClientes.getClientes();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    };
    @RequestMapping(value = "/facturas",produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<Factura>> buscarFacturas(){
        List<Factura> facturas = servicioFacturas.getFacturas();
        return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
    };
}
