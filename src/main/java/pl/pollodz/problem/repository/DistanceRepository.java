package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;

import java.time.LocalDateTime;
import java.util.List;

public interface DistanceRepository extends JpaRepository<DistanceMeasurement, Long> {
    @Query("SELECT e FROM DistanceMeasurement e JOIN fetch e.device d WHERE " +
            "d.id = :deviceId AND e.timestamp >= :start AND e.timestamp <= :end")
    List<DistanceMeasurement> getDistanceMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                     @Param("end")LocalDateTime end,
                                                                     @Param("deviceId")Long deviceId);
}
