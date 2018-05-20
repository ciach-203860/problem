package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

public class TemperatureMeasurementConverter {
    public static DoubleMeasurementDto toTemperatureMeasurementDto(TemperatureMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }
}
