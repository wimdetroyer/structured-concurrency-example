package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class StructuredconcurrencyexampleApplication implements CommandLineRunner {

	@Autowired
	private PlanetInfoService planetInfoService;
	@Autowired
	private ViaSingleThreaded viaSingleThreaded;

	@Autowired
	ViaVirtualThreadPerTaskExecutorService viaVirtualThreadPerTaskExecutorService;
    @Autowired
    private ViaTraditionalTaskExecutorService viaTraditionalTaskExecutorService;
    @Autowired
    private ViaStructuredConcurrencyUsingVirtualThreadss viaStructuredConcurrencyUsingVirtualThreadss;

	public static void main(String[] args) {
		SpringApplication.run(StructuredconcurrencyexampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("\n========== SEQUENTIAL EXECUTION ==========");
//		Instant startSequential = Instant.now();
//		System.out.println("Starting sequential calls...");
//		System.out.println("Result: " + viaSingleThreaded.getALlPlanets());
//		Instant endSequential = Instant.now();
//		System.out.println("Time taken (sequential): " + formatDuration(Duration.between(startSequential, endSequential)));
//		System.out.println("========== END SEQUENTIAL EXECUTION ==========\n");

//		System.out.println("========== VIRTUAL THREAD EXECUTION ==========");
//		Instant startVirtual = Instant.now();
//		System.out.println("Starting virtual threads...");
//		System.out.println("Result: " + viaVirtualThreadPerTaskExecutorService.getALlPlanets());
//		Instant endVirtual = Instant.now();
//		System.out.println("Time taken (virtual threads): " + formatDuration(Duration.between(startVirtual, endVirtual)));
//		System.out.println("========== END VIRTUAL THREAD EXECUTION ==========\n");
//
//		System.out.println("========== PLATFORM THREAD EXECUTION ==========");
//		Instant startPlatform = Instant.now();
//		System.out.println("Starting platform threads...");
//		System.out.println("Result: " + viaTraditionalTaskExecutorService.getALlPlanets());
//		Instant endPlatform = Instant.now();
//		System.out.println("Time taken (platform threads): " + formatDuration(Duration.between(startPlatform, endPlatform)));
//		System.out.println("========== END PLATFORM THREAD EXECUTION ==========\n");


		System.out.println("========== STRUCTURED CONCURRENCY (VIRTUAL THREADS) ==========");
		Instant startStructuredVirtual = Instant.now();
		System.out.println("Starting structured concurrency with virtual threads...");
		System.out.println("Result: " + viaStructuredConcurrencyUsingVirtualThreadss.getALlPlanets());
		Instant endStructuredVirtual = Instant.now();
		System.out.println("Time taken (structured concurrency with virtual threads): " + formatDuration(Duration.between(startStructuredVirtual, endStructuredVirtual)));
		System.out.println("========== END STRUCTURED CONCURRENCY (VIRTUAL THREADS) ==========\n");
	}

	private String formatDuration(Duration duration) {
		long millis = duration.toMillis();
		long seconds = millis / 1000;
		long remainingMillis = millis % 1000;
		return seconds + "." + String.format("%03d", remainingMillis) + " seconds";
	}

}
