package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;

import java.util.Date;
import java.util.List;

public interface MagneticService {

    List<MagneticMeasurement> getAll();

    List<DoubleMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId);

    List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end);

    void save(MagneticMeasurement temp);
}
