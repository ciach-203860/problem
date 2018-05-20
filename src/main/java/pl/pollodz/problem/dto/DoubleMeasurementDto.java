package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DoubleMeasurementDto {
    long deviceId;
    double measurement;
    LocalDateTime timestamp;
}
