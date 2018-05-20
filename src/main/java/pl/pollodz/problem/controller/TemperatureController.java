package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollodz.problem.service.TemperatureService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/temperatureMeasurement")
public class TemperatureController {
    @Autowired
    TemperatureService service;

    @RequestMapping(value = "/{deviceId}",
            method = RequestMethod.POST)
    public ResponseEntity getMeasurementFromPeriodOfTime(@RequestParam("start") LocalDateTime start,
                                         @RequestParam("end") LocalDateTime end,
                                         @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getTemperatureMeasurementsFromPeriodOfTime(start,end,deviceId));
    }
}
