package co.com.udea.facturacion.clientes.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

@Component
public class SimpleProducer {

    @Autowired
    private Producer<String, String> producer;

    public void send(String topic, String payload) {
        producer.send(new ProducerRecord<>(topic, payload));
    }

}
