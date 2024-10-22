package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StructuredconcurrencyexampleApplication implements CommandLineRunner {

	@Autowired
	private PlanetInfoService planetInfoService;

	public static void main(String[] args) {
		SpringApplication.run(StructuredconcurrencyexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(planetInfoService.getPlanetInfo(1));
	}
}
