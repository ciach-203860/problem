package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DetectionMeasurementDto {
    private long deviceId;
    private LocalDateTime measurement;
    private LocalDateTime timestamp;
}
