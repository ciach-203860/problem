package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.LightingMeasurement;

import java.util.Date;
import java.util.List;

public interface LightingService {

    List<LightingMeasurement> getAll();

    List<DoubleMeasurementDto> getLightingMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    void save(LightingMeasurement temp);
}
