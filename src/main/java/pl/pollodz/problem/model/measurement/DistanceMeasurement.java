package pl.pollodz.problem.model.measurement;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "distance_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class DistanceMeasurement extends AbstractMeasurement {

    @Column(name = "measurement")
    private Double measurement;
}
