package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DetectionMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDetectionMeasurement;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.DetectionConverter;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;
import pl.pollodz.problem.repository.DetectionRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultDetectionService implements DetectionService {

    @Autowired
    private DetectionRepository detectionRepository;

    @Override
    public List<DetectionMeasurement> getAll() {
        return detectionRepository.findAll();
    }

    @Override
    public List<DetectionMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<DetectionMeasurement> measurements = detectionRepository
                .getDetectionMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(DetectionConverter::toDetectionMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDetectionMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<DetectionMeasurement> measurements;
        if(start == null || end == null) {
            measurements = detectionRepository.findByDeviceId(deviceId);
        } else {
            measurements = detectionRepository
                    .getDetectionMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                            deviceId);
        }
        return measurements.stream()
                .map(DetectionConverter::toExtendedDetectionMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDetectionMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end) {
        List<DetectionMeasurement> measurements;
        if(start == null || end == null) {
            measurements = detectionRepository.findAll();
        } else {
            measurements = detectionRepository
                    .getDetectionMeasurementsFromPeriodOfTime(DateConverter.toLocalDataTime(start),
                            DateConverter.toLocalDataTime(end));
        }
        return measurements.stream()
                .map(DetectionConverter::toExtendedDetectionMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public void save(DetectionMeasurement temp) {
        detectionRepository.saveAndFlush(temp);
    }
}
