package co.com.udea.compras.rabbit;

import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;
import co.com.udea.compras.modelo.Factura;

@Component
public class ConsumidorFactura implements MessageListener {

  Gson gson = new Gson();

  @Override
  public void onMessage(Message message) {

    Factura factura = gson.fromJson(new String(message.getBody()), Factura.class);
    System.out.println( "Factura procesada: "+ factura.getIdFactura() + ", DniCliente: "     +  factura.getDniCliente() + ", IdSap: " + factura.getIdSap());
  }

}
