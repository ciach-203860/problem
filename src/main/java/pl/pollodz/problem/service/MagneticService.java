package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;

import java.util.Date;
import java.util.List;

public interface MagneticService {

    List<MagneticMeasurement> getAll();

    List<DoubleMeasurementDto> getMagneticMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    void save(MagneticMeasurement temp);
}
