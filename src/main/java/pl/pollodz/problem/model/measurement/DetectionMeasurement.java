package pl.pollodz.problem.model.measurement;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity(name = "detection_measurements")
@EqualsAndHashCode(callSuper = true)
@Data
public class DetectionMeasurement extends AbstractMeasurement {
}
