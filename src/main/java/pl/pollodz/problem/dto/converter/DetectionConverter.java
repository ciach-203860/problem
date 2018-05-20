package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DetectionMeasurementDto;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;

public class DetectionConverter {
    public static DetectionMeasurementDto toDetectionMeasurementDto(DetectionMeasurement t){
        return DetectionMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .measurement(t.getMeasurement())
                .timestamp(t.getTimestamp())
                .build();
    }
}
