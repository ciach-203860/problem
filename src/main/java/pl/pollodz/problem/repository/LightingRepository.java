package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.LightingMeasurement;

public interface LightingRepository extends JpaRepository<LightingMeasurement, Long> {
}
