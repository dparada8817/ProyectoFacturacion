package co.com.udea.sap.servicio;

import co.com.udea.sap.modelo.Factura;
import co.com.udea.sap.rabbit.PublicadorSap;
import co.com.udea.sap.rabbit.conf.RabbitConsumidorConf;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SapService {
    Gson gson = new Gson();

    @Autowired
    PublicadorSap publicador = new PublicadorSap();

    public void generarPublicarFacturaSap(Factura facturaSap) {
        String idSAp = UUID.randomUUID().toString();
        facturaSap.setIdSap(idSAp);
        publicador.publicarMensaje(RabbitConsumidorConf.EXCHANGE_FACTURASPROCESADA, gson.toJson(facturaSap));
    }


}
