package no.oslomet.clintrestproject.service;

import no.oslomet.clintrestproject.Bulding;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class BuldingService {
    String BASE_URL = "http://localhost:9998/buildings";
    private RestTemplate restTemplate = new RestTemplate();

    public List<Bulding> getAllBulding() {
        return Arrays.stream(
                restTemplate.getForObject(BASE_URL, Bulding[].class)
        ).collect(Collectors.toList());

    }


    public Bulding getBuildingById(long id) {
        Bulding bulding = restTemplate.getForObject(BASE_URL + "/" + id, Bulding.class);
        return bulding;
    }

    public Bulding saveBuilding(Bulding newBulding) {
        return restTemplate.postForObject(BASE_URL, newBulding, Bulding.class);

    }

}
