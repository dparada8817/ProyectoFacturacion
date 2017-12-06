package co.com.udea.facturacion.msfacturacion.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by DavidAlexander on 05/12/2017.
 */

public class Factura {

    private String idSap;
    private Cliente cliente;
    private List<Item> producto;

    public Factura() {
    }


    public String getIdSap() {
        return idSap;
    }

    public void setIdSap(String idSap) {
        this.idSap = idSap;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getProducto() {
        return producto;
    }

    public void setProducto(List<Item> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Factura{" +
                ", idSap='" + idSap + '\'' +
                ", cliente=" + cliente +
                ", producto=" + producto +
                '}';
    }
}
