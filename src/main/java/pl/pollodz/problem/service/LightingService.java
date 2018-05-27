package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.measurement.LightingMeasurement;

import java.util.Date;
import java.util.List;

public interface LightingService {

    List<LightingMeasurement> getAll();

    List<DoubleMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end);

    void save(LightingMeasurement temp);
}
