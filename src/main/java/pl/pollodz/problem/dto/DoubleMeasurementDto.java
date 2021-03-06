package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DoubleMeasurementDto {
    private long deviceId;
    private double measurement;
    private LocalDateTime timestamp;
}
