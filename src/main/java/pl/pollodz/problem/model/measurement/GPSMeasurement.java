package pl.pollodz.problem.model.measurement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.pollodz.problem.model.measurement.additional.Coordinate;

import javax.persistence.Entity;

@Entity(name = "gps_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class GPSMeasurement extends AbstractMeasurement {

    private Coordinate coordinate;
}
