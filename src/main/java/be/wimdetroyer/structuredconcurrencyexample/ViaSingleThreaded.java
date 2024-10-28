package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class ViaSingleThreaded extends AbstractGetAllPlanetService {


    public ViaSingleThreaded(PlanetInfoService planetInfoService) {
        super(planetInfoService);
    }

    @Override
    public List<String> getALlPlanets() {
        return IntStream.rangeClosed(PLANET_IDX_START, PLANET_IDX_END)
                .mapToObj(planetId -> {
                    try {
                    return planetInfoService.getPlanetInfo(planetId);
                    } catch (Exception e) {
                        System.out.println("Error!");
                        return "ERROR";
                    }
                })
                .toList();
    }
}