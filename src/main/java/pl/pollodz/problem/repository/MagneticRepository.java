package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;

public interface MagneticRepository extends JpaRepository<MagneticMeasurement, Long> {
}
