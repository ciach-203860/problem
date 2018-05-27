package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.ExtendedGPSMeasurement;
import pl.pollodz.problem.dto.GPSMeasurementDto;
import pl.pollodz.problem.model.measurement.GPSMeasurement;

import java.util.Date;
import java.util.List;

public interface GPSService {

    List<GPSMeasurement> getAll();

    List<GPSMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedGPSMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedGPSMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end);

    void save(GPSMeasurement temp);
}
