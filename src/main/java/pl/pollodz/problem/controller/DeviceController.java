package pl.pollodz.problem.controller;


import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.service.*;

import java.util.Date;


@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @Autowired
    private TemperatureService temperatureService;

    @Autowired
    private MagneticService magneticService;

    @Autowired
    private LightingService lightingService;

    @Autowired
    private HumidityService humidityService;

    @Autowired
    private GPSService gpsService;

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private DetectionService detectionService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAllDevices());
    }

    @RequestMapping(value = "/{deviceId}",
            method = RequestMethod.GET)
    public ResponseEntity getExtendedMeasurementFromPeriodOfTime( @RequestParam(value = "start", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                                  @RequestParam(value = "end", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end,
                                                                  @PathVariable("deviceId") Long deviceId){
        Device device = service.getById(deviceId).get();
        MeasurementType measurementType = device.getMeasurementType();
        switch (measurementType){
            case TEMPERATURE:
                return ResponseEntity.ok(temperatureService.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
            case AZIMUTH:
                return ResponseEntity.ok(magneticService.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
            case DISTANCE:
                return ResponseEntity.ok(distanceService.getExtendedMeasurementFromPeriodOfTime(start,end,deviceId));
            case HUMIDITY:
                return ResponseEntity.ok(humidityService.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
            case LIGHTING:
                return ResponseEntity.ok(lightingService.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
            case MOTION_ANALYSIS:
                return ResponseEntity.ok(gpsService.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
            case MOTION_DETECTION:
                return ResponseEntity.ok(detectionService.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
        }
        return ResponseEntity.status(400).build();
    }
    @RequestMapping(value = "/{deviceId}/measurements",
            method = RequestMethod.GET)
    public ResponseEntity getUniversalMeasurementsFromPeriodOfTime( @RequestParam(value = "start", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                                    @RequestParam(value = "end", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end,
                                                                    @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getMeasuermentsForDevices(start,end,deviceId));
    }

}
