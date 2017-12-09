package co.com.udea.facturacion.clientes.controller;

import co.com.udea.facturacion.clientes.modelo.Cliente;
import co.com.udea.facturacion.clientes.servicio.ServicioClientes;
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
public class ClientesController {

    @Autowired
    ServicioClientes servicioClientes;

    @RequestMapping(value = "/clientes",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Cliente>> buscarSerie(){
        List<Cliente> clientes = servicioClientes.getClientes();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    };
}
