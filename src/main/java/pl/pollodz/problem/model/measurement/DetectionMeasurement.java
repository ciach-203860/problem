package pl.pollodz.problem.model.measurement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pollodz.problem.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "detection_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class DetectionMeasurement extends AbstractMeasurement {

    @Column(name = "measurement")
    private LocalDateTime measurement;

    @Builder
    private DetectionMeasurement(Device device, LocalDateTime timestamp, LocalDateTime measurement) {
        super.setDevice(device);
        super.setTimestamp(timestamp);
        this.measurement = measurement;
    }
}
