package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.HumidityMeasurement;
import pl.pollodz.problem.repository.HumidityRepository;

import java.util.List;

@Service
@Transactional
public class DefaultHumidityService implements HumidityService {

    @Autowired
    private HumidityRepository humidityRepository;

    @Override
    public List<HumidityMeasurement> getAll() {
        return humidityRepository.findAll();
    }
}
