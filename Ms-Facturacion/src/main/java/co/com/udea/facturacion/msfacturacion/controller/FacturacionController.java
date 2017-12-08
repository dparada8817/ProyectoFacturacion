package co.com.udea.facturacion.msfacturacion.controller;

import co.com.udea.facturacion.msfacturacion.modelo.Factura;
import co.com.udea.facturacion.msfacturacion.modelo.PersistenciaException;
import co.com.udea.facturacion.msfacturacion.rabbit.Publicador;
import co.com.udea.facturacion.msfacturacion.rabbit.RabbitConf;
import co.com.udea.facturacion.msfacturacion.repositorio.FacturaRepositorio;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.FacturaEntities;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.UtilMapper;
import co.com.udea.facturacion.msfacturacion.servicio.ServicioFacturacion;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@RestController
public class FacturacionController {


    Gson gson = new Gson();

    @Autowired
    ServicioFacturacion servicioFacturacion;

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @RequestMapping(method = RequestMethod.POST, value = "/factura")
    public ResponseEntity<Object> crearFactura(@RequestBody Factura factura){
        ResponseEntity<Object> respuesta = null;
        try{
            Long idFactura = servicioFacturacion.crearFactura(factura);
            respuesta = new ResponseEntity<Object>(idFactura, HttpStatus.ACCEPTED);
        }catch (PersistenciaException e){
            respuesta = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return respuesta;
    }
}
