package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.DistanceMeasurementConverter;
import pl.pollodz.problem.dto.converter.LightingMeasurementConverter;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;
import pl.pollodz.problem.model.measurement.LightingMeasurement;
import pl.pollodz.problem.repository.DistanceRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultDistanceService implements DistanceService {

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public List<DistanceMeasurement> getAll() {
        return distanceRepository.findAll();
    }

    @Override
    public List<DoubleMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<DistanceMeasurement> measurements = distanceRepository
                .getDistanceMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(DistanceMeasurementConverter::toDoubleMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDoubleMeasurement> getExtendedMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<DistanceMeasurement> measurements;
        if(start == null || end == null) {
            measurements = distanceRepository.findByDeviceId(deviceId);
        } else {
            measurements = distanceRepository
                    .getDistanceMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                            deviceId);
        }
        return measurements.stream()
                .map(DistanceMeasurementConverter::toExtendedDoubleMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDoubleMeasurement> getExtendedMeasurementFromPeriodOfTime(Date start, Date end) {
        List<DistanceMeasurement> measurements;
        if(start == null || end == null) {
            measurements = distanceRepository.findAll();
        } else {
            measurements = distanceRepository
                    .getDistanceMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start),
                            DateConverter.toLocalDataTime(end));
        }
        return measurements.stream()
                .map(DistanceMeasurementConverter::toExtendedDoubleMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public void save(DistanceMeasurement temp) {
        distanceRepository.saveAndFlush(temp);
    }
}
