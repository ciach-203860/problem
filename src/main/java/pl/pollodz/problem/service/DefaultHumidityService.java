package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.HumidityMeasurementConverter;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;
import pl.pollodz.problem.repository.HumidityRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultHumidityService implements HumidityService {

    @Autowired
    private HumidityRepository humidityRepository;

    @Override
    public List<HumidityMeasurement> getAll() {
        return humidityRepository.findAll();
    }

    @Override
    public List<DoubleMeasurementDto> getHumidityMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<HumidityMeasurement> measurements = humidityRepository
                .getHumidityMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(HumidityMeasurementConverter::toDoubleMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(HumidityMeasurement temp) {
        humidityRepository.saveAndFlush(temp);
    }
}
