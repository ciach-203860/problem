package pl.pollodz.problem.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.CoordinateMapper;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.GPSMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.GPSService;

import java.time.LocalDateTime;

@Slf4j
public class MotionAnalysisMapper extends BaseMapper {

    @Autowired
    private GPSService gpsService;

    @Autowired
    private CoordinateMapper coordinateMapper;

    public MotionAnalysisMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForMotionAnalysis(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
        }
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
        //if (log.isDebugEnabled()) {
            log.info("Saving motion analysis measurement: " + temp + " in database.");
        //}
        gpsService.save(temp);
    }
}
