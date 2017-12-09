package co.com.udea.facturacion.clientes.rabbit;


import co.com.udea.facturacion.clientes.modelo.Cliente;
import co.com.udea.facturacion.clientes.servicio.ServicioClientes;

import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumidor implements MessageListener {

    Gson gson = new Gson();

    @Autowired
    ServicioClientes servicioClientes;


    @Override
    public void onMessage(Message message) {
        Cliente cliente = gson.fromJson(new String(message.getBody()), Cliente.class);
        servicioClientes.crearActualizarCliente(cliente);
    }
}
