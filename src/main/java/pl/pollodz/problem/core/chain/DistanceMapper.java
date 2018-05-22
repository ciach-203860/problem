package pl.pollodz.problem.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.DoubleMapper;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.DistanceService;

import java.time.LocalDateTime;

@Slf4j
public class DistanceMapper extends BaseMapper {

    @Autowired
    private DistanceService distanceService;

    @Autowired
    private DoubleMapper doubleMapper;

    public DistanceMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForDistance(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
        }
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
        //if (log.isDebugEnabled()) {
            log.info("Saving distance measurement: " + temp + " in database.");
        //}
        distanceService.save(temp);
    }
}
