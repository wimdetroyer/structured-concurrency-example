package be.wimdetroyer.structuredconcurrencyexample;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlanetInfoService {

    private static final String SWAPI_PLANETS_URL = "http://localhost:8080/api/planets/";

    public String getPlanetInfo(int planetId) {
        System.out.println("Getting planet with ID + " + planetId);
        RestTemplate restTemplate = new RestTemplate();
        String planetUrl = SWAPI_PLANETS_URL + planetId;
        return restTemplate.getForObject(planetUrl, String.class);



    }
}