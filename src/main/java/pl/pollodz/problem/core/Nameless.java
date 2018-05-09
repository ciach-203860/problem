package pl.pollodz.problem.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollodz.problem.exception.NoDeviceWithGivenIdException;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.Unit;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.response.MeasurementsList;
import pl.pollodz.problem.service.DeviceService;

@Service
@Slf4j
public class Nameless {

    // TODO refactor, this class is only for tests

    @Autowired
    private DeviceService deviceService;

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
                makeSomeLogicForTemperature(measurement, device.getUnit());
                break;
            case LIGHTING:
                makeSomeLogicForLighting(measurement, device.getUnit());
                break;
            case HUMIDITY:
                makeSomeLogicForHumidity(measurement, device.getUnit());
                break;
            case MOTION_DETECTION:
                makeSomeLogicForMotionDetection(measurement, device.getUnit());
                break;
            case MOTION_ANALYSIS:
                makeSomeLogicForMotionAnalysis(measurement, device.getUnit());
                break;
            case DISTANCE:
                makeSomeLogicForDistance(measurement, device.getUnit());
                break;
            case AZIMUTH:
                makeSomeLogicForAzimuth(measurement, device.getUnit());
                break;
        }
    }

    private void makeSomeLogicForTemperature(Measurement measurement, Unit unit) {
        switch (unit) {
            case CELSIUS:

                break;
            case FAHRENHEIT:

                break;
        }
    }

    private void makeSomeLogicForLighting(Measurement measurement, Unit unit) {
        switch (unit) {
            case UNKNOWN:

                break;
        }
    }

    private void makeSomeLogicForHumidity(Measurement measurement, Unit unit) {
        switch (unit) {
            case PERCENTAGE:

                break;
        }
    }

    private void makeSomeLogicForMotionDetection(Measurement measurement, Unit unit) {
        switch (unit) {
            case DATE:

                break;
        }
    }

    private void makeSomeLogicForMotionAnalysis(Measurement measurement, Unit unit) {
        switch (unit) {
            case COORDINATES:

                break;
        }
    }

    private void makeSomeLogicForDistance(Measurement measurement, Unit unit) {
        switch (unit) {
            case CENTIMETER:

                break;
        }
    }

    private void makeSomeLogicForAzimuth(Measurement measurement, Unit unit) {
        switch (unit) {
            case DEGREE:

                break;
        }
    }
}
