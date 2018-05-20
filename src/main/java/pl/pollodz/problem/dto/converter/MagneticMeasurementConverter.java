package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;

public class MagneticMeasurementConverter {
    public static DoubleMeasurementDto toDoubleMeasurementDto(MagneticMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }
}
