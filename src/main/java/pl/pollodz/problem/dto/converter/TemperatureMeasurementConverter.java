package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.TemperatureMeasurementDto;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

public class TemperatureMeasurementConverter {
    public static TemperatureMeasurementDto toTemperatureMeasurementDto(TemperatureMeasurement t){
        return TemperatureMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }
}
