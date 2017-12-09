package co.com.udea.sap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MsSapApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSapApplication.class, args);
	}
}
