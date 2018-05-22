package pl.pollodz.problem.core.chain;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pollodz.problem.core.mapper.DoubleMapper;
import pl.pollodz.problem.core.translator.TemperatureTranslator;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.service.TemperatureService;

import java.time.LocalDateTime;

@Slf4j
public class TemperatureMapper extends BaseMapper {

    @Autowired
    private TemperatureService temperatureService;

    @Autowired
    private DoubleMapper doubleMapper;

    @Autowired
    private TemperatureTranslator temperatureTranslator;

    public TemperatureMapper(BaseMapper baseMapper, MeasurementType measurementType) {
        super(baseMapper, measurementType);
    }

    @Override
    public void handleMeasurement(Measurement measurement, Device device) {
        if (canHandleMeasurement(device)) {
            makeSomeLogicForTemperature(measurement, device);
        } else {
            super.handleMeasurement(measurement, device);
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
        //if (log.isDebugEnabled()) {
            log.info("Saving temperature measurement: " + temp + " in database.");
        //}
        temperatureService.save(temp);
    }
}
