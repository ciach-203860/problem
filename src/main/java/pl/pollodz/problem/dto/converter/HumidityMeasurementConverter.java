package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;

public class HumidityMeasurementConverter {
    public static DoubleMeasurementDto toDoubleMeasurementDto(HumidityMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }
}
