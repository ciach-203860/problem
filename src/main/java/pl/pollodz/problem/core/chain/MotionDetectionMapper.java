package pl.pollodz.problem.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.DateMapper;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.DetectionService;

import java.time.LocalDateTime;

@Slf4j
public class MotionDetectionMapper extends BaseMapper {

    @Autowired
    private DetectionService detectionService;

    @Autowired
    private DateMapper dateMapper;

    public MotionDetectionMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForMotionDetection(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
        }
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
        //if (log.isDebugEnabled()) {
            log.info("Saving motion detection measurement: " + temp + " in database.");
        //}
        detectionService.save(temp);
    }
}
