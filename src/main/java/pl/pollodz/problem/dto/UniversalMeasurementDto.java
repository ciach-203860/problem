package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UniversalMeasurementDto {
    private long deviceId;
    private String measurement;
    private LocalDateTime timestamp;
    private String unit;
    private String measurementType;
}
