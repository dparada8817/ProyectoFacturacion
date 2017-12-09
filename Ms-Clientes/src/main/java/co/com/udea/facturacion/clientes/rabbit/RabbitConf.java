package co.com.udea.facturacion.clientes.rabbit;


import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConf {

    @Autowired
    Consumidor consumidor;

    public static final String LOCALHOST = "spider.rmq.cloudamqp.com";
    public static final String USER_UDEA = "fahnijad";
    public static final String PASSWORD = "JhFeJ_eTqOt7gsf40d5gVr3RN5yw5ot2";

    public static String EXCHANGE_FACTURASRECIBIDA = "udea.facturacion.facturarecibida";
    public static String ROUTINGKEY_CLIENTES = "clienterecibido";
    public static String EXCHANGE_CLIENTES = "udea.facturacion.cliente";
    public static final String COLA_CLIENTE_RECIBIDO = "udea.facturacion.cliente.clienterecibido";

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

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(getConnectionFactory());
        return template;
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(consumidor);
        container.setQueueNames(COLA_CLIENTE_RECIBIDO);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return container;
    }

}
