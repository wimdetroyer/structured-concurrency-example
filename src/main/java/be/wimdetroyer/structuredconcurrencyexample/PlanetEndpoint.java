package be.wimdetroyer.structuredconcurrencyexample;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetEndpoint {


    @GetMapping("/api/planets/{id}")
    public String getPlanetById(@PathVariable String id) throws InterruptedException {
        // 1% chance to throw an exception
        if (Math.random() < 0.05) {
            throw new RuntimeException("Random failure occurred!");
        }

        int delay = (int) (Math.random() * 500) + 1;

        System.out.println("sleeping randomly for " + delay);
        Thread.sleep(delay);
        return "Planet " + id + " is ready";
    }

}
