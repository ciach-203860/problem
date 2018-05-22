package pl.pollodz.problem.core.chain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.DoubleMapper;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.MagneticService;

import java.time.LocalDateTime;

@Slf4j
public class AzimuthMapper extends BaseMapper {

    @Autowired
    private MagneticService magneticService;

    @Autowired
    private DoubleMapper doubleMapper;

    public AzimuthMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForAzimuth(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
        }
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
        //if (log.isDebugEnabled()) {
            log.info("Saving azimuth measurement: " + temp + " in database.");
        //}
        magneticService.save(temp);
    }
}
