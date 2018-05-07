package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;

public interface HumidityRepository extends JpaRepository<HumidityMeasurement, Long> {
}
