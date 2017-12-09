package co.com.udea.sap.rabbit.conf;


import co.com.udea.sap.rabbit.ConsumidorSap;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConsumidorConf extends RabbitConf {


    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(getConsumidor());
        container.setQueueNames(COLA_FACTURA_RECIBIDA);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return container;
    }

    @Bean
    public ConsumidorSap getConsumidor() {
        return  new ConsumidorSap();
    }

}
