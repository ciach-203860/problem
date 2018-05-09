package pl.pollodz.problem.model.measurement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pollodz.problem.model.device.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "distance_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class DistanceMeasurement extends AbstractMeasurement {

    @Column(name = "measurement")
    private Double measurement;

    @Builder
    private DistanceMeasurement(Device device, LocalDateTime timestamp, Double measurement) {
        super.setDevice(device);
        super.setTimestamp(timestamp);
        this.measurement = measurement;
    }
}
