package pl.pollodz.problem.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoordinateDto {

    private Double latitude;

    private Double longitude;
}
