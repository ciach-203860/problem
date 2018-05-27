package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.CoordinateDto;
import pl.pollodz.problem.dto.ExtendedGPSMeasurement;
import pl.pollodz.problem.dto.GPSMeasurementDto;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.model.measurement.GPSMeasurement;

public class GPSMeasurementConverter {
    public static GPSMeasurementDto toGPSMeasurementDto(GPSMeasurement t) {
        return GPSMeasurementDto.builder()
                .deviceId(t.getDevice().getId())
                .coordinate(CoordinateDto.builder()
                        .latitude(t.getCoordinate().getLatitude())
                        .longitude(t.getCoordinate().getLongitude())
                        .build())
                .timestamp(t.getTimestamp())
                .build();
    }

    public static ExtendedGPSMeasurement toExtendedGPSMeasurement(GPSMeasurement t) {
        return ExtendedGPSMeasurement.builder()
                .deviceId(t.getDevice().getId())
                .coordinate(CoordinateDto.builder()
                        .latitude(t.getCoordinate().getLatitude())
                        .longitude(t.getCoordinate().getLongitude())
                        .build())
                .timestamp(t.getTimestamp())
                .measurementType(t.getDevice().getMeasurementType().name())
                .unit(t.getDevice().getUnit().name())
                .build();
    }
}
