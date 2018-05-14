package pl.pollodz.problem.model.measurement;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.measurement.additional.Coordinate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "gps_measurements")
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
