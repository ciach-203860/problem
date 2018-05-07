package pl.pollodz.problem.model.measurement;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "humidity_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class HumidityMeasurement extends AbstractMeasurement {

    @Column(name = "measurement")
    private Double measurement;
}
