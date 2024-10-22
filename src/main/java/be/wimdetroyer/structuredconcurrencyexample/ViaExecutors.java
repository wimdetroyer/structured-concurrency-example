package be.wimdetroyer.structuredconcurrencyexample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ViaExecutors extends AbstractGetAllPlanetService{


    public ViaExecutors(PlanetInfoService planetInfoService) {
        super(planetInfoService);
    }

    @Override
    public List<String> getALlPlanets() {
        try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {
            var executorCompletionService = new ExecutorCompletionService<String>(exec);
            executorCompletionService.
            List<Future<String>> futures = IntStream.rangeClosed(PLANET_IDX_START, PLANET_IDX_END)
                    .mapToObj(finalI -> exec.submit(() -> planetInfoService.getPlanetInfo(finalI)))
                    .toList();
            return futures.stream().map(f)
        }
    }
}
