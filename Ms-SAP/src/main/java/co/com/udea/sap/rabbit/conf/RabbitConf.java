package co.com.udea.sap.rabbit.conf;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;

public class RabbitConf {


    public static final String LOCALHOST = "spider.rmq.cloudamqp.com";
    public static final String USER_UDEA = "fahnijad";
    public static final String PASSWORD = "JhFeJ_eTqOt7gsf40d5gVr3RN5yw5ot2";

    public static String EXCHANGE_FACTURASPROCESADA = "udea.facturacion.facturaprocesada";
    public static final String COLA_FACTURA_RECIBIDA = "udea.facturacion.sap.facturarecibida";

    @Bean
    public ConnectionFactory getConnectionFactory(){
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(LOCALHOST);
        cachingConnectionFactory.setUsername(USER_UDEA);
        cachingConnectionFactory.setPassword(PASSWORD);
        cachingConnectionFactory.setVirtualHost(USER_UDEA);
        cachingConnectionFactory.setChannelCheckoutTimeout(10000);
        cachingConnectionFactory.setRequestedHeartBeat(3000);
        return cachingConnectionFactory;
    }
}
