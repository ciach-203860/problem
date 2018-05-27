package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.ExtendedDoubleMeasurement;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.TemperatureMeasurementConverter;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;
import pl.pollodz.problem.repository.TemperatureRepository;

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
    public List<DoubleMeasurementDto> getMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<TemperatureMeasurement> measurements = temperatureRepository
                .getTemperatureMeasurementsFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(TemperatureMeasurementConverter::toTemperatureMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<TemperatureMeasurement> measurements;
        if(start == null || end == null) {
            measurements = temperatureRepository.findByDeviceId(deviceId);
        } else {
            measurements = temperatureRepository
                    .getTemperatureMeasurementsFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                            deviceId);
        }
        return measurements.stream()
                .map(TemperatureMeasurementConverter::toExtendedDoubleMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExtendedDoubleMeasurement> getExtendedMeasurementsFromPeriodOfTime(Date start, Date end) {
        List<TemperatureMeasurement> measurements;
        if(start == null || end == null) {
            measurements = temperatureRepository.findAll();
        } else {
            measurements = temperatureRepository
                    .getTemperatureMeasurementsFromPeriodOfTime(DateConverter.toLocalDataTime(start),
                            DateConverter.toLocalDataTime(end));
        }
        return measurements.stream()
                .map(TemperatureMeasurementConverter::toExtendedDoubleMeasurement)
                .collect(Collectors.toList());
    }

    @Override
    public void save(TemperatureMeasurement measurement) {
        temperatureRepository.saveAndFlush(measurement);
    }
}
