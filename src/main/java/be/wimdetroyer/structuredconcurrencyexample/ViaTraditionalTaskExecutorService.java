
package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Component
public class ViaTraditionalTaskExecutorService extends AbstractGetAllPlanetService{


    public ViaTraditionalTaskExecutorService(PlanetInfoService planetInfoService) {
        super(planetInfoService);
    }

    @Override
    public List<String> getALlPlanets() {
        try (var exec = Executors.newCachedThreadPool()) {
            var callables = IntStream.rangeClosed(PLANET_IDX_START, PLANET_IDX_END)
                    .mapToObj(finalI -> (Callable<String>) () -> planetInfoService.getPlanetInfo(finalI))
                    .toList();
            try {
                var futures = exec.invokeAll(callables);
                return futures.stream().map(stringFuture -> {
                    try {
                        return stringFuture.get();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("interupted for some reason, ignoring");
                    } catch (ExecutionException e) {
                        return "KAPUT";
                    }
                    return "KAPUT";
                }).toList();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interupted for some reason, ignoring");
            }
        }
        return List.of();
    }
}
