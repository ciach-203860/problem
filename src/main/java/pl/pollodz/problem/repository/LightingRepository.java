package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pollodz.problem.model.measurement.LightingMeasurement;

import java.time.LocalDateTime;
import java.util.List;

public interface LightingRepository extends JpaRepository<LightingMeasurement, Long> {
    @Query("SELECT e FROM LightingMeasurement e JOIN fetch e.device d WHERE " +
            "d.id = :deviceId AND e.timestamp >= :start AND e.timestamp <= :end")
    List<LightingMeasurement> getLightingMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                     @Param("end")LocalDateTime end,
                                                                     @Param("deviceId")Long deviceId);

    @Query("SELECT e FROM LightingMeasurement e JOIN fetch e.device d WHERE " +
            "e.timestamp >= :start AND e.timestamp <= :end")
    List<LightingMeasurement> getLightingMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                     @Param("end")LocalDateTime end);

    List<LightingMeasurement> findByDeviceId(Long deviceId);
}
