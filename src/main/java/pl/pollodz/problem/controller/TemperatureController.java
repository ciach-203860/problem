package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @RequestMapping(value = "/{deviceId}/{start}/{end}",
            method = RequestMethod.GET)
    public ResponseEntity getMeasurementFromPeriodOfTime( @PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                          @PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end,
                                                         @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getTemperatureMeasurementsFromPeriodOfTime(start,end,deviceId));
    }
}
