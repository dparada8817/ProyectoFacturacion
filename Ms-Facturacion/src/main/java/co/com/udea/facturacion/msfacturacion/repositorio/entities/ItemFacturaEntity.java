package co.com.udea.facturacion.msfacturacion.repositorio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Entity
public class ItemFacturaEntity {



    @Id
    @GeneratedValue
    private Long iditfa;

    private Long idItem;

    private Long idFactura;
    private String producto;
    private int cantidad;

    public ItemFacturaEntity() {
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
}
