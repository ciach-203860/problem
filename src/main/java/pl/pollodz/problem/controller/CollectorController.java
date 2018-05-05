package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.pojo.SimpleMeasurementsList;
import pl.pollodz.problem.repository.DeviceRepository;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CollectorController {

    @Autowired
    private DeviceRepository deviceRepository;

    @RequestMapping(value = "collect", method = POST)
    public String collectData(@RequestBody SimpleMeasurementsList measurementsList) {

        Device device = deviceRepository.findByDeviceId("thermometer_1");

        return "Collection complete.";
    }
}
