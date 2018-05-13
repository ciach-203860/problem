package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TemperatureMeasurementDto {
    long deviceId;
    double measurement;
    LocalDateTime timestamp;
}
