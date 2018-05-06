package pl.pollodz.problem.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollodz.problem.response.SimpleMeasurementsList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CollectorController {

    @RequestMapping(value = "collect", method = POST)
    public String collectData(@RequestBody SimpleMeasurementsList measurementsList) {
        return "Collection complete.";
    }
}
