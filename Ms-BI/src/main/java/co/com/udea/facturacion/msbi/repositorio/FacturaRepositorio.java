package co.com.udea.facturacion.msbi.repositorio;


import co.com.udea.facturacion.msbi.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Component
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {
}
