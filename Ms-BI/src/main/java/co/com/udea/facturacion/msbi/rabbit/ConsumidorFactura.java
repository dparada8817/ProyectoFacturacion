package co.com.udea.facturacion.msbi.rabbit;

import co.com.udea.facturacion.msbi.modelo.Factura;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;


@Component
public class ConsumidorFactura implements MessageListener {

  Gson gson = new Gson();

  @Override
  public void onMessage(Message message) {
    Factura factura = gson.fromJson(new String(message.getBody()), Factura.class);
    System.out.println( "Factura procesada --- IdFactura "+ factura.getIdFactura() + ", DniCliente: "  +  factura.getDniCliente() + ", IdSap: " + factura.getIdSap());
  }

}
