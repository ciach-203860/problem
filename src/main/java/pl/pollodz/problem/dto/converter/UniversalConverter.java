package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.UniversalMeasurementDto;
import pl.pollodz.problem.model.measurement.*;

public class UniversalConverter {
    public static UniversalMeasurementDto toUniversalMeasurementDto(TemperatureMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getMeasurement().toString());
        return measurementDto;
    }

    public static UniversalMeasurementDto toUniversalMeasurementDto(DistanceMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getMeasurement().toString());
        return measurementDto;
    }

    public static UniversalMeasurementDto toUniversalMeasurementDto(GPSMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getCoordinate().toString());
        return measurementDto;
    }

    public static UniversalMeasurementDto toUniversalMeasurementDto(HumidityMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getMeasurement().toString());
        return measurementDto;
    }

    public static UniversalMeasurementDto toUniversalMeasurementDto(LightingMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getMeasurement().toString());
        return measurementDto;
    }

    public static UniversalMeasurementDto toUniversalMeasurementDto(MagneticMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getMeasurement().toString());
        return measurementDto;
    }

    public static UniversalMeasurementDto toUniversalMeasurementDto(DetectionMeasurement t){
        UniversalMeasurementDto measurementDto = setDeviceInfo(t);
        measurementDto.setMeasurement(t.getMeasurement().toString());
        return measurementDto;
    }

    private static UniversalMeasurementDto setDeviceInfo(AbstractMeasurement a) {
       return UniversalMeasurementDto.builder()
                .deviceId(a.getDevice().getId())
                .timestamp(a.getTimestamp())
                .measurementType(a.getDevice().getMeasurementType().name())
                .unit(a.getDevice().getUnit().name())
                .build();
    }
}
