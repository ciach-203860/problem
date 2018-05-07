package pl.pollodz.problem.model.measurement;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "lighting_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class LightingMeasurement extends AbstractMeasurement {

    @Column(name = "measurement")
    private Double measurement;
}
