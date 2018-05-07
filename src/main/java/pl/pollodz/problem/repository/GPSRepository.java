package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.GPSMeasurement;

public interface GPSRepository extends JpaRepository<GPSMeasurement, Long> {
}
