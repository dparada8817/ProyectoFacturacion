package co.com.udea.facturacion.msfacturacion.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Publicador {

    ApplicationContext cxt = new AnnotationConfigApplicationContext(RabbitConf.class);
    RabbitTemplate template = cxt.getBean(RabbitTemplate.class);

    public void publicarMensajeSap(String exchange, String mensaje){
        CompletableFuture.runAsync(()->{
            System.out.println(exchange + " "+mensaje);
            template.convertAndSend(exchange,"",mensaje);
        });
    }
}
