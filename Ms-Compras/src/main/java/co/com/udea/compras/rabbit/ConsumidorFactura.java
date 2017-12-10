package co.com.udea.compras.rabbit;

import co.com.udea.compras.servicio.ServicioFacturas;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.udea.compras.modelo.Factura;

@Component
public class ConsumidorFactura implements MessageListener {

  Gson gson = new Gson();

  @Autowired
  private ServicioFacturas servicioFacturas;

  @Override
  public void onMessage(Message message) {

    Factura factura = gson.fromJson(new String(message.getBody()), Factura.class);
    servicioFacturas.crearActualizarFactura(factura);
    System.out.println( "Factura almacenada: "+ factura.getIdFactura() + ", DniCliente: "     +  factura.getDniCliente() + ", IdSap: " + factura.getIdSap());

  }

}
