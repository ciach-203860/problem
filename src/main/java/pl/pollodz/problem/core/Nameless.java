package pl.pollodz.problem.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollodz.problem.core.chain.*;
import pl.pollodz.problem.exception.NoDeviceWithGivenIdException;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.response.MeasurementsList;
import pl.pollodz.problem.service.*;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class Nameless {

    // TODO refactor, this class is only for tests

    @Autowired
    private DeviceService deviceService;

    @Autowired
    AzimuthMapper azimuthMapper;

    @Autowired
    DistanceMapper distanceMapper;

    @Autowired
    HumidityMapper humidityMapper;

    @Autowired
    LightingMapper lightingMapper;

    @Autowired
    MotionAnalysisMapper motionAnalysisMapper;

    @Autowired
    MotionDetectionMapper motionDetectionMapper;

    @Autowired
    TemperatureMapper temperatureMapper;

    @PostConstruct
    public void init() {

        azimuthMapper
                .setBaseMapper(distanceMapper
                        .setBaseMapper(humidityMapper
                                .setBaseMapper(lightingMapper
                                        .setBaseMapper(motionAnalysisMapper
                                                .setBaseMapper(motionDetectionMapper
                                                        .setBaseMapper(temperatureMapper))))));
    }

    public void nameless(MeasurementsList list) {

        for (Measurement measurement : list.getMeasurements()) {

            try {

                Device device = deviceService.getById(Long.parseLong(measurement.getDeviceId()))
                        .orElseThrow(NoDeviceWithGivenIdException::new);

                azimuthMapper.handleMeasurement(measurement, device);

            } catch (Exception exception) {
                if (log.isErrorEnabled()) {
                    log.error("Measurement processing for " + measurement + " failed.", exception);
                }
            }
        }
    }
}
