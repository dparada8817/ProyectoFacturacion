package co.com.udea.facturacion.msfacturacion.servicio;

import co.com.udea.facturacion.msfacturacion.modelo.Factura;
import co.com.udea.facturacion.msfacturacion.modelo.PersistenciaException;
import co.com.udea.facturacion.msfacturacion.rabbit.Publicador;
import co.com.udea.facturacion.msfacturacion.rabbit.conf.RabbitConf;
import co.com.udea.facturacion.msfacturacion.repositorio.FacturaRepositorio;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.FacturaEntities;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.UtilMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DavidAlexander on 08/12/2017.
 */

@Component
public class ServicioFacturacion {

    Gson gson = new Gson();

    @Autowired
    Publicador publicador;

    @Autowired
    FacturaRepositorio facturaRepositorio;


    public Long crearFactura(Factura factura) throws PersistenciaException {
        FacturaEntities save = crearActualizarFactura(UtilMapper.getFacturaEntity(factura));

        ResponseEntity respuesta = null;
        if(save!=null){
            publicador.publicarMensaje(RabbitConf.EXCHANGE_FACTURASRECIBIDA,gson.toJson(save));
            publicador.publicarMensaje(RabbitConf.EXCHANGE_CLIENTES,RabbitConf.ROUTINGKEY_CLIENTES, gson.toJson(factura.getCliente()) );
        }else{
          throw new PersistenciaException("Error al guardar la Factura");
        }

        return save.getIdFactura();
    }


    public FacturaEntities crearActualizarFactura( FacturaEntities save){
        return facturaRepositorio.save(save);
    }


    public List<Factura> getFacturas() {
        List<FacturaEntities> facturaEntities = facturaRepositorio.findAll();
        return UtilMapper.getFacturaFromEntity(facturaEntities);
    }
}
