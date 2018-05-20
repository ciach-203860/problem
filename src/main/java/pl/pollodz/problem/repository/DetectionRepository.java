package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;

import java.time.LocalDateTime;
import java.util.List;

public interface DetectionRepository extends JpaRepository<DetectionMeasurement, Long> {
    @Query("SELECT e FROM DetectionMeasurement e JOIN fetch e.device d WHERE " +
            "d.id = :deviceId AND e.timestamp >= :start AND e.timestamp <= :end")
    List<DetectionMeasurement> getDetectionMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                       @Param("end")LocalDateTime end,
                                                                       @Param("deviceId")Long deviceId);
}
