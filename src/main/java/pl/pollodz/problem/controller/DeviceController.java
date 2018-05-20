package pl.pollodz.problem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pollodz.problem.service.DeviceService;


@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAllDevices());
    }
}
