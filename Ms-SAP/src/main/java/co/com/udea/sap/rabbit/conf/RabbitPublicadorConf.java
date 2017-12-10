package co.com.udea.sap.rabbit.conf;


import co.com.udea.sap.rabbit.PublicadorSap;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitPublicadorConf extends RabbitConf {


    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(getConnectionFactory());
        return template;
    }
}
