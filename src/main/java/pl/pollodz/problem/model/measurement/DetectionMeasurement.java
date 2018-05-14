package pl.pollodz.problem.model.measurement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;
import pl.pollodz.problem.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "detection_measurements")
public class DetectionMeasurement extends AbstractMeasurement {

    @Column(name = "measurement")
    private LocalDateTime measurement;

    @Builder
    private DetectionMeasurement(Device device, LocalDateTime timestamp, LocalDateTime measurement) {
        super.setDevice(device);
        super.setTimestamp(timestamp);
        this.measurement = measurement;
    }

    @Tolerate
    public DetectionMeasurement() {
    }
}
