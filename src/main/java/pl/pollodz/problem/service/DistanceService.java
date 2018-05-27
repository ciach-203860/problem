package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;

import java.util.Date;
import java.util.List;

public interface DistanceService {

    List<DistanceMeasurement> getAll();

    List<DoubleMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementFromPeriodOfTime(Date start, Date end);

    void save(DistanceMeasurement temp);
}
