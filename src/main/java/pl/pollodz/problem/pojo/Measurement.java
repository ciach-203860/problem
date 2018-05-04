package pl.pollodz.problem.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Measurement {

    @JsonProperty(value = "deviceId")
    private String deviceId;

    @JsonProperty(value = "value")
    private String value;
}
