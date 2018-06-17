package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pollodz.problem.core.Nameless;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.measurement.*;
import pl.pollodz.problem.response.MeasurementsList;
import pl.pollodz.problem.service.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TestController {

    private static final String MM_1 = "http://michalmalec.synology.me:8888/two?token=67tyghHJG7GJfghm";
    private static final String MM_2 = "http://michalmalec.synology.me:8888/one?token=67tyghHJG7GJfghm";

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
    private JsonResponse jsonResponse;

    @RequestMapping(value = "crawler1", method = GET)
    public String crawler1() throws URISyntaxException {

        MeasurementsList list = jsonResponse.invoke(new URI(MM_1), MeasurementsList.class);

        nameless.nameless(list);

        return "crawler1";
    }

    @RequestMapping(value = "crawler2", method = GET)
    public String crawler2() throws URISyntaxException {

        MeasurementsList list = jsonResponse.invoke(new URI(MM_2), MeasurementsList.class);

        nameless.nameless(list);

        return "crawler2";
    }

    @RequestMapping(value = "collect", method = POST)
    public String collectData(@RequestBody MeasurementsList measurementsList) {

        //region test

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
