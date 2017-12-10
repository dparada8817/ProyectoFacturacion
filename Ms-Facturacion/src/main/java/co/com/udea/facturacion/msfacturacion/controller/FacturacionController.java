package co.com.udea.facturacion.msfacturacion.controller;

import co.com.udea.facturacion.msfacturacion.modelo.Factura;
import co.com.udea.facturacion.msfacturacion.modelo.PersistenciaException;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.FacturaEntities;
import co.com.udea.facturacion.msfacturacion.servicio.ServicioFacturacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@RestController
public class FacturacionController {


    @Autowired
    ServicioFacturacion servicioFacturacion;


    @RequestMapping(method = RequestMethod.POST, value = "/factura")
    public ResponseEntity<Object> crearFactura(@RequestBody Factura factura){
        ResponseEntity<Object> respuesta = null;
        try{
            FacturaEntities idFactura = servicioFacturacion.crearFactura(factura);
            respuesta = new ResponseEntity<Object>(idFactura, HttpStatus.ACCEPTED);
        }catch (PersistenciaException e){
            respuesta = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return respuesta;
    }

    @RequestMapping(value = "/facturas",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Factura>> buscarSerie(){
        List<Factura> facturas = servicioFacturacion.getFacturas();
        return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
    };
}
