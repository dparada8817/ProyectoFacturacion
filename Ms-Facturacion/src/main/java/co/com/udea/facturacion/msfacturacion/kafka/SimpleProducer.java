package co.com.udea.facturacion.msfacturacion.kafka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {
/*	public static void main(String[] args) throws IOException {
		
		int index = 0;
		KafkaProducer<String, String> producer = new KafkaProducer<>(KafkaConfig.createProducerProps());

		int c = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		while (c != 0) {  // check for EOF
			c = Integer.parseInt(br.readLine());
			System.out.println("total: " + c);
			
			for (int i = 0; i < c; i++) {
				ProducerRecord<String, String> record = new ProducerRecord<String, String>("t1", String.format("Hi Kafka (%d) [%s]", ++index, new Date()));
				
				producer.send(record);
				producer.flush();
				System.out.println("send ....");
			}
		}
		
		producer.close();
	}*/

}
