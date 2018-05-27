package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DetectionMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDetectionMeasurement;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;

public class DetectionConverter {
    public static DetectionMeasurementDto toDetectionMeasurementDto(DetectionMeasurement t){
        return DetectionMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }

    public static ExtendedDetectionMeasurement toExtendedDetectionMeasurement(DetectionMeasurement t) {
        return ExtendedDetectionMeasurement.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .measurementType(t.getDevice().getMeasurementType().name())
                .unit(t.getDevice().getUnit().name())
                .build();
    }
}
