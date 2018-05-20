package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class GPSMeasurementDto {
    private CoordinateDto coordinate;
    private long deviceId;
    private LocalDateTime timestamp;
}
