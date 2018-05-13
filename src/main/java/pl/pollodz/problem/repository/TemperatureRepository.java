package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TemperatureRepository extends JpaRepository<TemperatureMeasurement, Long> {
    //TODO: naprawić to zapytanie - mimo, że wygląda ok :D :D
    /*@Query("SELECT e FROM TemperatureMeasurement e JOIN fetch e.device d WHERE " +
            "d.id = :deviceId AND e.timestamp >= :start AND e.timestamp <= :end")
     List<TemperatureMeasurement> getTemperatureMeasurementsFromPeriodOfTime(@Param("start")Date start,
                                                                             @Param("end")Date end,
                                                                             @Param("deviceId")Long deviceId);*/
}
