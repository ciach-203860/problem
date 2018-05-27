package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DetectionMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDetectionMeasurement;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;

import java.util.Date;
import java.util.List;

public interface DetectionService {

    List<DetectionMeasurement> getAll();

    public List<DetectionMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDetectionMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDetectionMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end);

    void save(DetectionMeasurement temp);
}
