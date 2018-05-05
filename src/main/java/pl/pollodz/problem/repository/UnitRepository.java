package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.device.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

    Unit findByDescription(String description);
}
