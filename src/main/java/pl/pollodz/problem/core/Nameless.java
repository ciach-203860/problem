package pl.pollodz.problem.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollodz.problem.core.mapper.CoordinateMapper;
import pl.pollodz.problem.core.mapper.DateMapper;
import pl.pollodz.problem.core.mapper.DoubleMapper;
import pl.pollodz.problem.core.translator.TemperatureTranslator;
import pl.pollodz.problem.exception.NoDeviceWithGivenIdException;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.measurement.*;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.response.MeasurementsList;
import pl.pollodz.problem.service.*;

import java.time.LocalDateTime;

@Service
@Slf4j
public class Nameless {

    // TODO refactor, this class is only for tests

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
    private DoubleMapper doubleMapper;

    @Autowired
    private CoordinateMapper coordinateMapper;

    @Autowired
    private TemperatureTranslator temperatureTranslator;

    @Autowired
    private DateMapper dateMapper;

    public void nameless(MeasurementsList list) {

        for (Measurement measurement : list.getMeasurements()) {

            try {

                Device device = deviceService.getById(Long.parseLong(measurement.getDeviceId()))
                        .orElseThrow(NoDeviceWithGivenIdException::new);

                makeSomeLogicDependsOnDevice(measurement, device);

            } catch (Exception exception) {
                if (log.isErrorEnabled()) {
                    log.error("Measurement processing for " + measurement + " failed.", exception);
                }
            }
        }
    }

    private void makeSomeLogicDependsOnDevice(Measurement measurement, Device device) {

        switch (device.getMeasurementType()) {
            case TEMPERATURE:
                makeSomeLogicForTemperature(measurement, device);
                break;
            case LIGHTING:
                makeSomeLogicForLighting(measurement, device);
                break;
            case HUMIDITY:
                makeSomeLogicForHumidity(measurement, device);
                break;
            case MOTION_DETECTION:
                makeSomeLogicForMotionDetection(measurement, device);
                break;
            case MOTION_ANALYSIS:
                makeSomeLogicForMotionAnalysis(measurement, device);
                break;
            case DISTANCE:
                makeSomeLogicForDistance(measurement, device);
                break;
            case AZIMUTH:
                makeSomeLogicForAzimuth(measurement, device);
                break;
        }
    }

    private void makeSomeLogicForTemperature(Measurement measurement, Device device) {

        TemperatureMeasurement temp = TemperatureMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case CELSIUS:
                temp.setMeasurement(doubleMapper.map(measurement.getValue()));
                break;
            case FAHRENHEIT:
                temp.setMeasurement(temperatureTranslator.translate(
                        doubleMapper.map(measurement.getValue())
                ));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving temperature measurement: " + temp + " in database.");
        }
        temperatureService.save(temp);
    }

    private void makeSomeLogicForLighting(Measurement measurement, Device device) {

        LightingMeasurement temp = LightingMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case UNKNOWN:
                temp.setMeasurement(doubleMapper.map(measurement.getValue()));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving lighting measurement: " + temp + " in database.");
        }
        lightingService.save(temp);
    }

    private void makeSomeLogicForHumidity(Measurement measurement, Device device) {

        HumidityMeasurement temp = HumidityMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case PERCENTAGE:
                temp.setMeasurement(doubleMapper.map(measurement.getValue()));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving humidity measurement: " + temp + " in database.");
        }
        humidityService.save(temp);
    }

    private void makeSomeLogicForMotionDetection(Measurement measurement, Device device) {

        DetectionMeasurement temp = DetectionMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case DATE:
                temp.setMeasurement(dateMapper.map(measurement.getValue()));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving motion detection measurement: " + temp + " in database.");
        }
        detectionService.save(temp);
    }

    private void makeSomeLogicForMotionAnalysis(Measurement measurement, Device device) {

        GPSMeasurement temp = GPSMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case COORDINATES:
                temp.setCoordinate(coordinateMapper.map(measurement.getValue()));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving motion analysis measurement: " + temp + " in database.");
        }
        gpsService.save(temp);
    }

    private void makeSomeLogicForDistance(Measurement measurement, Device device) {

        DistanceMeasurement temp = DistanceMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case CENTIMETER:
                temp.setMeasurement(doubleMapper.map(measurement.getValue()));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving distance measurement: " + temp + " in database.");
        }
        distanceService.save(temp);
    }

    private void makeSomeLogicForAzimuth(Measurement measurement, Device device) {

        MagneticMeasurement temp = MagneticMeasurement
                .builder()
                .device(device)
                .timestamp(LocalDateTime.now())
                .build();
        switch (device.getUnit()) {
            case DEGREE:
                temp.setMeasurement(doubleMapper.map(measurement.getValue()));
                break;
        }
        if (log.isDebugEnabled()) {
            log.debug("Saving azimuth measurement: " + temp + " in database.");
        }
        magneticService.save(temp);
    }
}
