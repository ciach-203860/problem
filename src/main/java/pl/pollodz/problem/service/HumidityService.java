package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;

import java.util.Date;
import java.util.List;

public interface HumidityService {

    List<HumidityMeasurement> getAll();

    List<DoubleMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end);

    void save(HumidityMeasurement temp);
}
