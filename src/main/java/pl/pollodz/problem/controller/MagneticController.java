package pl.pollodz.problem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollodz.problem.service.MagneticService;

import java.util.Date;

@RestController
@RequestMapping("/api/magneticMeasurement")
public class MagneticController {
    @Autowired
    private MagneticService service;

    @RequestMapping(value = "/{deviceId}/{start}/{end}",
            method = RequestMethod.GET)
    public ResponseEntity getMeasurementFromPeriodOfTime(@PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                         @PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end,
                                                         @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getMeasurementFromPeriodOfTime(start,end,deviceId));
    }

    @RequestMapping(value = "/{deviceId}",
            method = RequestMethod.GET)
    public ResponseEntity getExtendedMeasurementFromPeriodOfTime( @RequestParam(value = "start", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                                  @RequestParam(value = "end", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end,
                                                                  @PathVariable("deviceId") Long deviceId){
        return ResponseEntity.ok(service.getExtendedMeasurementsFromPeriodOfTime(start,end,deviceId));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getExtendedMeasurementFromPeriodOfTime( @RequestParam(value = "start", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date start,
                                                                  @RequestParam(value = "end", required = false) @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") Date end)
    {
        return ResponseEntity.ok(service.getExtendedMeasurementsFromPeriodOfTime(start,end));
    }
}
