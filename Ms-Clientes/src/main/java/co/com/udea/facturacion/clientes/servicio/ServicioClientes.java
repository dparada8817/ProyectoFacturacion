package co.com.udea.facturacion.clientes.servicio;

import co.com.udea.facturacion.clientes.kafka.SimpleProducer;
import co.com.udea.facturacion.clientes.modelo.Cliente;
import co.com.udea.facturacion.clientes.repositorio.ClienteRepositorio;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DavidAlexander on 08/12/2017.
 */
@Component
public class ServicioClientes {

    Gson gson = new Gson();


    @Value("${kafka.topic.clientes}")
    private String topic;

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    SimpleProducer simpleProducer;

    public void crearActualizarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
        simpleProducer.send(topic,gson.toJson(cliente));
    }

    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }
}
