package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollodz.problem.service.TemperatureService;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/temperatureMeasurement")
public class TemperatureController {
    @Autowired
    TemperatureService service;

    @RequestMapping(value = "/{deviceId}",
            method = RequestMethod.POST)
    public ResponseEntity getMeasurementFromPeriodOfTime(@RequestParam("start") Date start,
                                         @RequestParam("end") Date end,
                                         @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getTemperatureMeasurementsFromPeriodOfTime(start,end,deviceId));
    }
}
