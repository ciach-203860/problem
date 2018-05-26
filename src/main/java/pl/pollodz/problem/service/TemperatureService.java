package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

import java.util.Date;
import java.util.List;

public interface TemperatureService {

    List<TemperatureMeasurement> getAll();

    List<DoubleMeasurementDto> getTemperatureMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedTemperatureMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedTemperatureMeasurementsFromPeriodOfTime(Date start, Date end);

    void save(TemperatureMeasurement measurement);
}
