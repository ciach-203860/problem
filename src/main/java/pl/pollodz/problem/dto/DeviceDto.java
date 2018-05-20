package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeviceDto {

    private Long id;

    private String name;

    private String measurementType;

    private String unit;

    private String descriptionKey;
}
