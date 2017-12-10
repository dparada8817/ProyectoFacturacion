package co.com.udea.compras.servicio;

import co.com.udea.compras.modelo.Cliente;
import co.com.udea.compras.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DavidAlexander on 08/12/2017.
 */
@Component
public class ServicioClientes {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    public void crearActualizarCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }
}
