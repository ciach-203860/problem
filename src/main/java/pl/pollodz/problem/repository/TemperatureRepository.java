package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

public interface TemperatureRepository extends JpaRepository<TemperatureMeasurement, Long> {
}
