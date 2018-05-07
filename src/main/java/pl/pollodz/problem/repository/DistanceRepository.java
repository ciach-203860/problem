package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;

public interface DistanceRepository extends JpaRepository<DistanceMeasurement, Long> {
}
