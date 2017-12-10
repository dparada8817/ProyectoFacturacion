package co.com.udea.facturacion.msbi.modelo;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Factura {
    @Id
    private Long idFactura;
    private String idSap;
    private String dniCliente;

    public Factura() {
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
