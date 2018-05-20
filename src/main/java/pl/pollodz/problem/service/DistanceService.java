package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;

import java.util.Date;
import java.util.List;

public interface DistanceService {

    List<DistanceMeasurement> getAll();

    List<DoubleMeasurementDto> getDistanceMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    void save(DistanceMeasurement temp);
}
