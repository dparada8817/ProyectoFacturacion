package co.com.udea.facturacion.clientes.repositorio;

import co.com.udea.facturacion.clientes.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by DavidAlexander on 08/12/2017.
 */
@Component
public interface ClienteRepositorio  extends JpaRepository<Cliente, Long> {
}
