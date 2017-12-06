package co.com.udea.facturacion.msfacturacion.repositorio;

import co.com.udea.facturacion.msfacturacion.modelo.Factura;
import co.com.udea.facturacion.msfacturacion.repositorio.entities.FacturaEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Component
public interface FacturaRepositorio extends JpaRepository<FacturaEntities, Long> {
}
