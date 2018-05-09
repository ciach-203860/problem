package pl.pollodz.problem.model.measurement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pollodz.problem.model.device.Device;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "detection_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class DetectionMeasurement extends AbstractMeasurement {

    @Builder
    private DetectionMeasurement(Device device, LocalDateTime timestamp) {
        super.setDevice(device);
        super.setTimestamp(timestamp);
    }
}
