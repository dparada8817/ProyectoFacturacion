package co.com.udea.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsComprasApplication.class, args);
	}
}
