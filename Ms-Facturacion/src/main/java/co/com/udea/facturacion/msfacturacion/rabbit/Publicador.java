package co.com.udea.facturacion.msfacturacion.rabbit;

import co.com.udea.facturacion.msfacturacion.rabbit.conf.RabbitConf;
import co.com.udea.facturacion.msfacturacion.rabbit.conf.RabbitPublicadorConf;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Publicador {

    ApplicationContext cxt = new AnnotationConfigApplicationContext(RabbitPublicadorConf.class);
    RabbitTemplate template = cxt.getBean(RabbitTemplate.class);

    public void publicarMensaje(String exchange, String mensaje){
        publicarMensaje(exchange, null,mensaje);
    }

    public void publicarMensaje(String exchange,String routingKey, String mensaje){
        CompletableFuture.runAsync(()->{
            System.out.println(exchange + " "+routingKey + " "+mensaje);
            template.convertAndSend(exchange,routingKey,mensaje);
        });
    }
}
