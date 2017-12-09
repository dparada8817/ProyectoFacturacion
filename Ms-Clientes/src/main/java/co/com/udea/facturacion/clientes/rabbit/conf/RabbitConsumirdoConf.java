package co.com.udea.facturacion.clientes.rabbit.conf;


import co.com.udea.facturacion.clientes.rabbit.Consumidor;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConsumirdoConf extends RabbitConf {

    @Autowired
    Consumidor consumidor;

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
