package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;

public class DistanceMeasurementConverter {
    public static DoubleMeasurementDto toDoubleMeasurementDto(DistanceMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }
}
