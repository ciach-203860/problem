package pl.pollodz.problem.restClient;

import lombok.*;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DefaultRestClient {

    private RestTemplate restTemplate;
    private String apiPath = "http://localhost:8090/api/"; // przykładowy adres api

    public void init(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Arrays.asList(new MappingJackson2HttpMessageConverter()));
    }

    public Map<String, String> getMeasurements() {
        Map<String,String> measurements = restTemplate.getForObject(apiPath + "/readFromSensors", Map.class, new HashMap<String,String>());
        return measurements;
    }
}
