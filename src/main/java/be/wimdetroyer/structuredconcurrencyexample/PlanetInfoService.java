package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlanetInfoService {

    private static final String SWAPI_PLANETS_URL = "https://swapi.dev/api/planets/";

    public String getPlanetInfo(int planetId) {
        RestTemplate restTemplate = new RestTemplate();
        String planetUrl = SWAPI_PLANETS_URL + planetId;
        return restTemplate.getForObject(planetUrl, String.class);



    }
}