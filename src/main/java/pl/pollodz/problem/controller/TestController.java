package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollodz.problem.core.Nameless;
import pl.pollodz.problem.corerefactored.NamelessRefactored;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.measurement.*;
import pl.pollodz.problem.response.MeasurementsList;
import pl.pollodz.problem.service.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TestController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DetectionService detectionService;

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private GPSService gpsService;

    @Autowired
    private HumidityService humidityService;

    @Autowired
    private LightingService lightingService;

    @Autowired
    private MagneticService magneticService;

    @Autowired
    private TemperatureService temperatureService;

    @Autowired
    private Nameless nameless;

    @Autowired
    private NamelessRefactored namelessRefactored;

    @RequestMapping(value = "collect", method = POST)
    public String collectData(@RequestBody MeasurementsList measurementsList) {

        //region test

        namelessRefactored.namelessRefactored();

        nameless.nameless(measurementsList);

        List<Device> devices = deviceService.getAll();
        Device device = deviceService.getByName("thermometer 1").orElse(null);

        List<DetectionMeasurement> detections = detectionService.getAll();
        List<DistanceMeasurement> distances = distanceService.getAll();
        List<GPSMeasurement> gpss = gpsService.getAll();
        List<HumidityMeasurement> humidities = humidityService.getAll();
        List<LightingMeasurement> lightings = lightingService.getAll();
        List<MagneticMeasurement> magnetics = magneticService.getAll();
        List<TemperatureMeasurement> temperatures = temperatureService.getAll();

        //endregion

        return "Collection complete.";
    }
}
