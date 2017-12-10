package co.com.udea.compras.servicio;

import co.com.udea.compras.modelo.Factura;
import co.com.udea.compras.repositorio.FacturaRepositorio;
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
