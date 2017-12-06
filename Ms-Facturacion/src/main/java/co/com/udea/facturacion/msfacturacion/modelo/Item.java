package co.com.udea.facturacion.msfacturacion.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long idItem;
    private String producto;
    private int cantidad;

    public Item() {
    }


    public Item(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
