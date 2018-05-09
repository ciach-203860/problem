package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.DistanceMeasurement;
import pl.pollodz.problem.repository.DistanceRepository;

import java.util.List;

@Service
@Transactional
public class DefaultDistanceService implements DistanceService {

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public List<DistanceMeasurement> getAll() {
        return distanceRepository.findAll();
    }

    @Override
    public void save(DistanceMeasurement temp) {
        distanceRepository.saveAndFlush(temp);
    }
}
