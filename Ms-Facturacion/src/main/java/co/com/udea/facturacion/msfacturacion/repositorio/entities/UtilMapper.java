package co.com.udea.facturacion.msfacturacion.repositorio.entities;

import co.com.udea.facturacion.msfacturacion.modelo.Factura;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
public class UtilMapper {

    public static FacturaEntities getFacturaEntity(Factura factura){
        FacturaEntities entity = new FacturaEntities();
        entity.setDniCliente(factura.getCliente().getDni());
        return entity;
    }
}
