package pl.pollodz.problem.dto.converter;

import pl.pollodz.problem.dto.DeviceDto;
import pl.pollodz.problem.model.device.Device;

public class DeviceConverter {

    public static DeviceDto toDeviceDto(Device d) {
        return DeviceDto.builder()
                .id(d.getId())
                .name(d.getName())
                .descriptionKey(d.getDescriptionKey())
                .measurementType(d.getMeasurementType().name())
                .unit(d.getUnit().name())
                .build();
    }
}
