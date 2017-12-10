package co.com.udea.compras.rabbit;


import co.com.udea.compras.servicio.ServicioClientes;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import co.com.udea.compras.modelo.Cliente;

@Component
public class ConsumidorCliente implements MessageListener {

  Gson gson = new Gson();

  @Autowired
  private ServicioClientes servicioClientes;

  @Override
  public void onMessage(Message message) {
    Cliente cliente = gson.fromJson(new String(message.getBody()), Cliente.class);
    servicioClientes.crearActualizarCliente(cliente);
    System.out.println("cliente almacenado: " + cliente.getNombre());
  }

}
