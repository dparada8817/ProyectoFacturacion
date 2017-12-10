package co.com.udea.facturacion.msbi.servicio;

import co.com.udea.facturacion.msbi.modelo.Factura;
import co.com.udea.facturacion.msbi.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DavidAlexander on 08/12/2017.
 */
@Component
public class ServicioFacturas {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    public void crearActualizarFactura(Factura factura) {
        facturaRepositorio.save(factura);
    }

    public List<Factura> getFacturas() {
        return facturaRepositorio.findAll();
    }
}
