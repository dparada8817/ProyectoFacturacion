package co.com.udea.facturacion.msfacturacion.rabbit.conf;


import co.com.udea.facturacion.msfacturacion.rabbit.Consumidor;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class RabbitConf  {

    public static final String LOCALHOST = "spider.rmq.cloudamqp.com";
    public static final String USER_UDEA = "fahnijad";
    public static final String PASSWORD = "JhFeJ_eTqOt7gsf40d5gVr3RN5yw5ot2";

    public static String EXCHANGE_FACTURASRECIBIDA = "udea.facturacion.facturarecibida";
    public static String ROUTINGKEY_CLIENTES = "clienterecibido";
    public static String EXCHANGE_CLIENTES = "udea.facturacion.cliente";
    public static final String COLA_FACTURA_PROCESADA = "udea.facturacion.factura.facturaprocesada";

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
