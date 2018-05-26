package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class ExtendedDoubleMeasurement {
    private long deviceId;
    private double measurement;
    private LocalDateTime timestamp;
    private String unit;
    private String measurementType;
}
