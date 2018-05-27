package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;

import java.time.LocalDateTime;
import java.util.List;

public interface HumidityRepository extends JpaRepository<HumidityMeasurement, Long> {
    @Query("SELECT e FROM HumidityMeasurement e JOIN fetch e.device d WHERE " +
            "d.id = :deviceId AND e.timestamp >= :start AND e.timestamp <= :end")
    List<HumidityMeasurement> getHumidityMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                    @Param("end")LocalDateTime end,
                                                                    @Param("deviceId")Long deviceId);

    @Query("SELECT e FROM HumidityMeasurement e JOIN fetch e.device d WHERE " +
            "e.timestamp >= :start AND e.timestamp <= :end")
    List<HumidityMeasurement> getHumidityMeasurementFromPeriodOfTime(@Param("start")LocalDateTime start,
                                                                     @Param("end")LocalDateTime end);

    List<HumidityMeasurement> findByDeviceId(Long deviceId);
}
