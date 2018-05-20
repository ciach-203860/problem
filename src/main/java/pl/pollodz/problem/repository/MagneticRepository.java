package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;

import java.time.LocalDateTime;
import java.util.List;

public interface MagneticRepository extends JpaRepository<MagneticMeasurement, Long> {
    @Query("SELECT e FROM MagneticMeasurement e JOIN fetch e.device d WHERE " +
            "d.id = :deviceId AND e.timestamp >= :start AND e.timestamp <= :end")
    List<MagneticMeasurement> getMagneticMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                         @Param("end")LocalDateTime end,
                                                                         @Param("deviceId")Long deviceId);
}
