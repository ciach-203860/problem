package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;

public class HumidityMeasurementConverter {
    public static DoubleMeasurementDto toDoubleMeasurementDto(HumidityMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }

    public static ExtendedDoubleMeasurement toExtendedDoubleMeasurement(HumidityMeasurement t) {
        return ExtendedDoubleMeasurement.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .measurementType(t.getDevice().getMeasurementType().name())
                .unit(t.getDevice().getUnit().name())
                .build();
    }
}
