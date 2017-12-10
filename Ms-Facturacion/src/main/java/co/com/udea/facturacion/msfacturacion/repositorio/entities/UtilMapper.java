package co.com.udea.facturacion.msfacturacion.repositorio.entities;

import co.com.udea.facturacion.msfacturacion.modelo.Cliente;
import co.com.udea.facturacion.msfacturacion.modelo.Factura;
import co.com.udea.facturacion.msfacturacion.modelo.Item;

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

    public static List<Factura> getFacturaFromEntity(List<FacturaEntities> facturaEntities, List<ItemFacturaEntity> itemsEntitis) {
        List<Factura> facturas = new ArrayList<>();
        facturaEntities.forEach(entity->{
            Factura factura = new Factura();
            factura.setIdFactura(entity.getIdFactura());
            factura.setIdSap(entity.getIdSap());
            Cliente cliente = new Cliente();
            cliente.setDni(entity.getDniCliente());
            factura.setCliente(cliente);
            List<Item> items = new ArrayList<>();
            itemsEntitis.forEach(it->{
                if(it.getIdFactura()==entity.getIdFactura()){
                    Item item = new Item();
                    item.setCantidad(it.getCantidad());
                    item.setProducto(it.getProducto());
                    items.add(item);
                }
            });
            factura.setProducto(items);


            facturas.add(factura);
        });
        return facturas;
    }

    public static List<ItemFacturaEntity> getItemFacturaEntity(Factura factura) {
        List<ItemFacturaEntity> entities = new ArrayList<>();
        factura.getProducto().forEach(s->{
            ItemFacturaEntity entity = new ItemFacturaEntity();
            entity.setCantidad(s.getCantidad());
            entity.setIdFactura(factura.getIdFactura());
            entity.setProducto(s.getProducto());
            entities.add(entity);
        });
        return entities;
    }
}
