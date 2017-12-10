package co.com.udea.compras.rabbit.conf;

import co.com.udea.compras.rabbit.ConsumidorFactura;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitFacturaConf {

  @Autowired
  ConsumidorFactura consumidor;

  public static final String LOCALHOST = "spider.rmq.cloudamqp.com";
  public static final String USER_UDEA = "fahnijad";
  public static final String PASSWORD = "JhFeJ_eTqOt7gsf40d5gVr3RN5yw5ot2";

  public static final String COLA_FACTURA_PROCESADA = "udea.facturacion.compras.facturaprocesada";

  @Bean
  public ConnectionFactory connectionFactory(){

    CachingConnectionFactory connectionFactory = new CachingConnectionFactory(LOCALHOST);
    connectionFactory.setUsername(USER_UDEA);
    connectionFactory.setPassword(PASSWORD);
    connectionFactory.setVirtualHost(USER_UDEA);

    connectionFactory.setChannelCheckoutTimeout(10000);
    connectionFactory.setRequestedHeartBeat(30);
    return connectionFactory;
  }

  @Bean
  public SimpleMessageListenerContainer containerFactura(ConnectionFactory connectionFactory) {
    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    container.setConnectionFactory(connectionFactory);
    container.setQueueNames(COLA_FACTURA_PROCESADA);
    container.setMessageListener(consumidor);
    container.setAcknowledgeMode(AcknowledgeMode.AUTO);
    return container;
  }

}
