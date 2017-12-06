package co.com.udea.facturacion.msfacturacion.repositorio.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by DavidAlexander on 05/12/2017.
 */
@Entity
public class FacturaEntities {

    @Id
    @GeneratedValue
    private Long idFactura;
    private String idSap;
    private String dniCliente;

    public FacturaEntities() {
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdSap() {
        return idSap;
    }

    public void setIdSap(String idSap) {
        this.idSap = idSap;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }
}
