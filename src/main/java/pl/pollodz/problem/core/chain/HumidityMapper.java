package pl.pollodz.problem.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.DoubleMapper;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.HumidityService;

import java.time.LocalDateTime;

@Slf4j
public class HumidityMapper extends BaseMapper {

    @Autowired
    private HumidityService humidityService;

    @Autowired
    private DoubleMapper doubleMapper;

    public HumidityMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForHumidity(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
        }
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
        //if (log.isDebugEnabled()) {
            log.info("Saving humidity measurement: " + temp + " in database.");
        //}
        humidityService.save(temp);
    }
}
