package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ViaStructuredConcurrency {

    private final PlanetInfoService planetInfoService;

    public ViaStructuredConcurrency(PlanetInfoService planetInfoService) {
        this.planetInfoService = planetInfoService;
    }

    public List<String>
}
