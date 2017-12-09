package co.com.udea.compras.repositorio;

import co.com.udea.compras.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
}
