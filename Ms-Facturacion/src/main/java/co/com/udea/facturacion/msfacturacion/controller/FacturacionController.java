package co.com.udea.facturacion.msfacturacion.controller;

import co.com.udea.facturacion.msfacturacion.modelo.Factura;
import co.com.udea.facturacion.msfacturacion.rabbit.Publicador;
import co.com.udea.facturacion.msfacturacion.rabbit.RabbitConf;
import co.com.udea.facturacion.msfacturacion.repositorio.FacturaRepositorio;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.FacturaEntities;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.UtilMapper;
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
    Publicador publicador;

    @Autowired
    FacturaRepositorio facturaRepositorio;

    @RequestMapping(method = RequestMethod.POST, value = "/regalo")
    public ResponseEntity<Long> crearRegalo(@RequestBody Factura factura){
        FacturaEntities save = facturaRepositorio.save(UtilMapper.getFacturaEntity(factura));

        ResponseEntity respuesta = null;
        if(save!=null){
            publicador.publicarMensajeSap(RabbitConf.EXCHANGE_FACTURASRECIBIDA,gson.toJson(save));
            respuesta = new ResponseEntity<Long>(save.getIdFactura(), HttpStatus.ACCEPTED);
        }else{
            respuesta = new ResponseEntity<Long>(save.getIdFactura(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return respuesta;
    }
}
