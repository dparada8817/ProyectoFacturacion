package co.com.udea.facturacion.msfacturacion.repositorio.entities;

import co.com.udea.facturacion.msfacturacion.modelo.Cliente;
import co.com.udea.facturacion.msfacturacion.modelo.Factura;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
public class UtilMapper {

    public static FacturaEntities getFacturaEntity(Factura factura){
        FacturaEntities entity = new FacturaEntities();
        entity.setDniCliente(factura.getCliente().getDni());
        return entity;
    }

    public static List<Factura> getFacturaFromEntity(List<FacturaEntities> facturaEntities) {
        List<Factura> facturas = new ArrayList<>();
        facturaEntities.forEach(entity->{
            Factura factura = new Factura();
            factura.setIdFactura(entity.getIdFactura());
            factura.setIdSap(entity.getIdSap());
            Cliente cliente = new Cliente();
            cliente.setDni(entity.getDniCliente());
            factura.setCliente(cliente);
            facturas.add(factura);
        });
        return facturas;
    }
}
