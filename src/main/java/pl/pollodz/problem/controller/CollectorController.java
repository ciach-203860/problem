package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.pojo.SimpleMeasurementsList;
import pl.pollodz.problem.service.DeviceService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class CollectorController {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "collect", method = POST)
    public String collectData(@RequestBody SimpleMeasurementsList measurementsList) {

        Device result = deviceService.getByDeviceId("thermometer_1")
                .orElseThrow(IllegalArgumentException::new);

        return "Collection complete.";
    }
}
