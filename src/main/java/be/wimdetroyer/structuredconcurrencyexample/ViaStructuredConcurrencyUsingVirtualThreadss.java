package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.IntStream;

@Component
public class ViaStructuredConcurrencyUsingVirtualThreadss extends AbstractGetAllPlanetService{


    public ViaStructuredConcurrencyUsingVirtualThreadss(PlanetInfoService planetInfoService) {
        super(planetInfoService);
    }

    @Override
    public List<String> getALlPlanets() {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var subtasks = IntStream.rangeClosed(PLANET_IDX_START, PLANET_IDX_END).mapToObj(id ->
                    scope.fork(() -> planetInfoService.getPlanetInfo(id))
            ).toList();
            try {
                scope.join(); // blocks
                return subtasks.stream().map(st -> {
                    if(StructuredTaskScope.Subtask.State.FAILED == st.state()) {
                        return "KA-BOOM!";
                    }
                    return st.get();
                }).toList();
            } catch (InterruptedException e) {
                System.out.println("Interrupted...");
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

}
