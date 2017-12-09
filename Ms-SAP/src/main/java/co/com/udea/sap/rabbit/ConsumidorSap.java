package co.com.udea.sap.rabbit;



import co.com.udea.sap.modelo.Factura;
import co.com.udea.sap.servicio.SapService;
import com.google.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorSap implements MessageListener {


    //@Autowired
    SapService sapService = new SapService();

    Gson gson = new Gson();

    @Override
    public void onMessage(Message message) {
        Factura facturaSap = gson.fromJson(new String(message.getBody()), Factura.class);
        sapService.generarPublicarFacturaSap(facturaSap);
    }


}
