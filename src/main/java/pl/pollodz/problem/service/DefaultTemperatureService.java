package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.TemperatureMeasurementDto;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.TemperatureMeasurementConverter;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;
import pl.pollodz.problem.repository.TemperatureRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultTemperatureService implements TemperatureService {

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Override
    public List<TemperatureMeasurement> getAll() {
        return temperatureRepository.findAll();
    }

    @Override
    public List<TemperatureMeasurementDto> getTemperatureMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<TemperatureMeasurement> measurements = temperatureRepository
                .getTemperatureMeasurementsFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(TemperatureMeasurementConverter::toTemperatureMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(TemperatureMeasurement measurement) {
        temperatureRepository.saveAndFlush(measurement);
    }
}
