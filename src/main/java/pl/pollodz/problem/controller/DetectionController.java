package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.pollodz.problem.service.DetectionService;

import java.util.Date;

@RestController
@RequestMapping("/api/detectionMeasurement")
public class DetectionController {

    @Autowired
    private DetectionService service;

    @RequestMapping(value = "/{deviceId}/{start}/{end}",
            method = RequestMethod.GET)
    public ResponseEntity getMeasurementFromPeriodOfTime(@PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                         @PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end,
                                                         @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getDetectionMeasurementFromPeriodOfTime(start,end,deviceId));
    }
}
