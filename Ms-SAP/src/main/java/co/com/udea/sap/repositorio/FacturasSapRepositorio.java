package co.com.udea.sap.repositorio;

import co.com.udea.sap.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FacturasSapRepositorio extends JpaRepository<Factura, String> {
}
