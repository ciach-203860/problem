package pl.pollodz.problem.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import pl.pollodz.problem.converter.ZonedDateTimeDeserializer;

import java.time.ZonedDateTime;

@Data
public class Measurement {

    @JsonProperty(value = "deviceId")
    private String deviceId;

    @JsonProperty(value = "value")
    private String value;

    @JsonProperty(value = "timestamp")
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime timestamp;
}
