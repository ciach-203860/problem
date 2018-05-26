package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

public class TemperatureMeasurementConverter {
    public static DoubleMeasurementDto toTemperatureMeasurementDto(TemperatureMeasurement t){
        return DoubleMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }

    public static ExtendedDoubleMeasurement toExtendedDoubleMeasurement(TemperatureMeasurement t) {
        return ExtendedDoubleMeasurement.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .measurementType(MeasurementType.TEMPERATURE.name())
                .unit(t.getDevice().getUnit().name())
                .build();
    }
}
