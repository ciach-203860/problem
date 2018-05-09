package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.LightingMeasurement;
import pl.pollodz.problem.repository.LightingRepository;

import java.util.List;

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
    public void save(LightingMeasurement temp) {
        lightingRepository.saveAndFlush(temp);
    }
}
