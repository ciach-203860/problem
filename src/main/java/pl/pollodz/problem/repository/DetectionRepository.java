package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;

public interface DetectionRepository extends JpaRepository<DetectionMeasurement, Long> {
}
