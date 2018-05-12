package pl.pollodz.problem.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import pl.pollodz.problem.converter.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@Data
public class Measurement {

    @JsonProperty(value = "deviceId")
    private String deviceId;

    @JsonProperty(value = "value")
    private String value;

//    @JsonProperty(value = "timestamp")
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    private LocalDateTime timestamp;
}
