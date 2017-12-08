package co.com.udea.facturacion.msfacturacion.rabbit;


import co.com.udea.facturacion.msfacturacion.repositorio.entities.FacturaEntities;
import co.com.udea.facturacion.msfacturacion.servicio.ServicioFacturacion;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumidor implements MessageListener {

    Gson gson = new Gson();

    @Autowired
    ServicioFacturacion servicioFacturacion;


    @Override
    public void onMessage(Message message) {
        FacturaEntities facturaSap = gson.fromJson(new String(message.getBody()), FacturaEntities.class);
        servicioFacturacion.crearActualizarFactura(facturaSap);
    }
}
