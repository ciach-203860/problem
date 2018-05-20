package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DoubleMeasurementDto;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.LightingMeasurementConverter;
import pl.pollodz.problem.dto.converter.MagneticMeasurementConverter;
import pl.pollodz.problem.model.measurement.LightingMeasurement;
import pl.pollodz.problem.repository.LightingRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultLightingService implements LightingService {

    @Autowired
    private LightingRepository lightingRepository;

    @Override
    public List<LightingMeasurement> getAll() {
        return lightingRepository.findAll();
    }

    @Override
    public List<DoubleMeasurementDto> getLightingMeasurementFromPeriodOfTime(Date start, Date end, long deviceId) {
        List<LightingMeasurement> measurements = lightingRepository
                .getLightingMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end),
                        deviceId);
        return measurements.stream()
                .map(LightingMeasurementConverter::toDoubleMeasurementDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(LightingMeasurement temp) {
        lightingRepository.saveAndFlush(temp);
    }
}
