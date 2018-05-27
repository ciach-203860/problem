package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.MagneticMeasurementConverter;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;
import pl.pollodz.problem.repository.MagneticRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultMagneticService implements MagneticService {

    @Autowired
    private MagneticRepository magneticRepository;

    @Override
    public List<MagneticMeasurement> getAll() {
        return magneticRepository.findAll();
    }

    @Override
    public List<DoubleMeasurementDto> getMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<MagneticMeasurement> measurements = magneticRepository
                .getMagneticMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(MagneticMeasurementConverter::toDoubleMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<MagneticMeasurement> measurements;
        if(start == null || end == null) {
            measurements = magneticRepository.findByDeviceId(deviceId);
        } else {
            measurements = magneticRepository
                    .getMagneticMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                            deviceId);
        }
        return measurements.stream()
                .map(MagneticMeasurementConverter::toExtendedDoubleMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end) {
        List<MagneticMeasurement> measurements;
        if(start == null || end == null) {
            measurements = magneticRepository.findAll();
        } else {
            measurements = magneticRepository
                    .getMagneticMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start),
                            DateConverter.toLocalDataTime(end));
        }
        return measurements.stream()
                .map(MagneticMeasurementConverter::toExtendedDoubleMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public void save(MagneticMeasurement temp) {
        magneticRepository.saveAndFlush(temp);
    }
}
