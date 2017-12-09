package co.com.udea.facturacion.clientes.rabbit.conf;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitPublicadorConf extends RabbitConf {

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(getConnectionFactory());
        return template;
    }

}