package co.com.udea.facturacion.msfacturacion;

import co.com.udea.facturacion.msfacturacion.modelo.Item;
import co.com.udea.facturacion.msfacturacion.repositorio.ItemRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MsFacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFacturacionApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ItemRepositorio itemRepositoriorepo){
		return new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception{
				List<Item> items = new ArrayList<>();
				items.add(new Item("producto1", 2));
				items.add(new Item("producto2", 2));
				items.add(new Item("producto3", 2));

				items.forEach(it -> itemRepositoriorepo.save(it));

				System.out.println(itemRepositoriorepo.findAll());

			}
		};
 	}
}
