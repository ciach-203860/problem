package pl.pollodz.problem.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SimpleMeasurementsList {

    @JsonProperty(value = "measurements")
    private List<SimpleMeasurement> measurements;
}
