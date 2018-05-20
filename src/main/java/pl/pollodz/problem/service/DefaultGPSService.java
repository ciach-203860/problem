package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.GPSMeasurementDto;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.GPSMeasurementConverter;
import pl.pollodz.problem.model.measurement.GPSMeasurement;
import pl.pollodz.problem.repository.GPSRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultGPSService implements GPSService {

    @Autowired
    private GPSRepository gpsRepository;

    @Override
    public List<GPSMeasurement> getAll() {
        return gpsRepository.findAll();
    }

    @Override
    public List<GPSMeasurementDto> getGPSMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<GPSMeasurement> measurements = gpsRepository
                .getGPSMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(GPSMeasurementConverter ::toGPSMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(GPSMeasurement temp) {
        gpsRepository.saveAndFlush(temp);
    }
}
