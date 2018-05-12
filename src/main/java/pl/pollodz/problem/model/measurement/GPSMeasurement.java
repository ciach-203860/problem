package pl.pollodz.problem.model.measurement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.measurement.additional.Coordinate;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity(name = "gps_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class GPSMeasurement extends AbstractMeasurement {

    private Coordinate coordinate;

    @Builder
    private GPSMeasurement(Device device, LocalDateTime timestamp, Coordinate coordinate) {
        super.setDevice(device);
        super.setTimestamp(timestamp);
        this.coordinate = coordinate;
    }

    @Tolerate
    public GPSMeasurement() {
    }
}
