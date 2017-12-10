package co.com.udea.sap.servicio;

import co.com.udea.sap.modelo.Factura;
import co.com.udea.sap.rabbit.PublicadorSap;
import co.com.udea.sap.rabbit.conf.RabbitConsumidorConf;
import co.com.udea.sap.repositorio.FacturasSapRepositorio;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SapService {
    Gson gson = new Gson();

    @Autowired
    PublicadorSap publicador;

    @Autowired
    FacturasSapRepositorio facturasSapRepositorio;

    public void generarPublicarFacturaSap(Factura facturaSap) {
        String idSAp = UUID.randomUUID().toString();
        facturaSap.setIdSap(idSAp);
        publicador.publicarMensaje(RabbitConsumidorConf.EXCHANGE_FACTURASPROCESADA, gson.toJson(facturaSap));
        facturasSapRepositorio.save(facturaSap);
    }


    public List<Factura> getFacturas() {
        return facturasSapRepositorio.findAll();
    }
}
