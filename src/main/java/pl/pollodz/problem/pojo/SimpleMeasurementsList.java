package pl.pollodz.problem.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SimpleMeasurementsList {

    @JsonProperty(value = "measurements")
    private List<SimpleMeasurement> measurements;
}
