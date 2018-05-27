package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.LightingMeasurement;

public class LightingMeasurementConverter {
    public static DoubleMeasurementDto toDoubleMeasurementDto(LightingMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }

    public static ExtendedDoubleMeasurement toExtendedDoubleMeasurement(LightingMeasurement t) {
        return ExtendedDoubleMeasurement.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .measurementType(MeasurementType.TEMPERATURE.name())
                .unit(t.getDevice().getUnit().name())
                .build();
    }
}
