package be.wimdetroyer.structuredconcurrencyexample;

import java.util.List;

public abstract class AbstractGetAllPlanetService {


    protected static int PLANET_IDX_START = 1;
    protected static int PLANET_IDX_END = 100;
    protected final PlanetInfoService planetInfoService;

    public AbstractGetAllPlanetService(PlanetInfoService planetInfoService) {
        this.planetInfoService = planetInfoService;
    }

    public abstract List<String> getALlPlanets();

}
