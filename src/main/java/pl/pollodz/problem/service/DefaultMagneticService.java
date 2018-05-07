package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.MagneticMeasurement;
import pl.pollodz.problem.repository.MagneticRepository;

import java.util.List;

@Service
@Transactional
public class DefaultMagneticService implements MagneticService {

    @Autowired
    private MagneticRepository magneticRepository;

    @Override
    public List<MagneticMeasurement> getAll() {
        return magneticRepository.findAll();
    }
}
