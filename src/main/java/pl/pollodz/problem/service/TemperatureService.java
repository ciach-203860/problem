package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.TemperatureMeasurementDto;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TemperatureService {

    List<TemperatureMeasurement> getAll();

    List<TemperatureMeasurementDto> getTemperatureMeasurementsFromPeriodOfTime(LocalDateTime start, LocalDateTime end, long deviceId);

    void save(TemperatureMeasurement measurement);
}
