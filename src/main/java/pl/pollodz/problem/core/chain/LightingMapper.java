package pl.pollodz.problem.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.DoubleMapper;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.LightingMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.LightingService;

import java.time.LocalDateTime;

@Slf4j
public class LightingMapper extends BaseMapper {

    @Autowired
    private LightingService lightingService;

    @Autowired
    private DoubleMapper doubleMapper;

    public LightingMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForLighting(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
        }
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
        //if (log.isDebugEnabled()) {
            log.info("Saving lighting measurement: " + temp + " in database.");
        //}
        lightingService.save(temp);
    }
}
