package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.TemperatureMeasurement;
import pl.pollodz.problem.repository.TemperatureRepository;

import java.util.List;

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
    public void save(TemperatureMeasurement measurement) {
        temperatureRepository.saveAndFlush(measurement);
    }
}
