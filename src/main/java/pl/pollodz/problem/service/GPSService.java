package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.GPSMeasurementDto;
import pl.pollodz.problem.model.measurement.GPSMeasurement;

import java.util.Date;
import java.util.List;

public interface GPSService {

    List<GPSMeasurement> getAll();

    List<GPSMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    void save(GPSMeasurement temp);
}
