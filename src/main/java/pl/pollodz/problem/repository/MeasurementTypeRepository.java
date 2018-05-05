package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.device.MeasurementType;

public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Long> {

    MeasurementType findByDescription(String description);
}
