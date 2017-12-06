package co.com.udea.facturacion.msfacturacion.kafka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.function.Consumer;
/*
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import io.vertx.core.json.Json;
import io.vertx.example.domain.CartDomain;
import io.vertx.example.model.Cart;
*/
public class SimpleConsumer {
/*	static public class ConsumerThread<R, T> implements Runnable {

		private String name;
		private Consumer<R> fresponse;
		private final KafkaConsumer<String, T> consumer;

		public ConsumerThread(String topic, String name, Consumer<R> fresponse) {
			this.name = name;
			this.fresponse = fresponse;
			this.consumer = new KafkaConsumer<String, T>(KafkaConfig.createConsumerProps());
			this.consumer.subscribe(Collections.singletonList(topic));
		}

		@SuppressWarnings("unchecked")
		public void run() {
			try {
				boolean isRunning = true;
				while (isRunning) {
					ConsumerRecords<String, T> records = consumer.poll(100L);
					Iterator<?> it = records.iterator();

//					if (it.hasNext()) {
//						System.out.println(name + " -------------- Partition Assignment to this Consumer: " + consumer.assignment());
//					}

					while (it.hasNext()) {
						ConsumerRecord<String, T> record = (ConsumerRecord<String, T>) it.next();
						
						fresponse.accept((R)record);

						System.out.println(String.format(
								"Received message from thread : %s (%s, %s) at offset %s", name, record.key(), record.value(), record.offset()));
//						Thread.sleep(1000);
					}
					consumer.commitAsync();
				}
				consumer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Consumer-%d").build();
		ExecutorService executor = Executors.newFixedThreadPool(3, threadFactory);
		
		final KafkaProducer<String, String> producer = new KafkaProducer<>(KafkaConfig.createProducerProps());

		executor.submit(new ConsumerThread<ConsumerRecord<String, String>, String>("t1", "myThread-" + new Date(), record -> {
			try {
				Message message = Message.from(record.value());
				
				if( message.getHostname() != null ){
					Cart cart = Json.decodeValue(message.getData(), Cart.class);
					CartDomain.execute(cart);
					message.setData(Json.encode(cart));
					
					ProducerRecord<String, String> newRecord = new ProducerRecord<String, String>("t2-"+message.getHostname(), Message.to(message));		
					producer.send(newRecord);
					producer.flush();
				}else{
					System.out.println("Error: hostname null !!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
//		executor.submit(new ConsumerThread("t1", "myThread-" + new Date()));
//		executor.submit(new ConsumerThread("t1", "myThread-" + new Date()));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer.parseInt(br.readLine());
		executor.shutdown();
		producer.close();
	}*/
}
