package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.DetectionMeasurement;
import pl.pollodz.problem.repository.DetectionRepository;

import java.util.List;

@Service
@Transactional
public class DefaultDetectionService implements DetectionService {

    @Autowired
    private DetectionRepository detectionRepository;

    @Override
    public List<DetectionMeasurement> getAll() {
        return detectionRepository.findAll();
    }
}
