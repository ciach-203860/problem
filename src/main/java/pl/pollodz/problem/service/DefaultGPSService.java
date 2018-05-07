package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.measurement.GPSMeasurement;
import pl.pollodz.problem.repository.GPSRepository;

import java.util.List;

@Service
@Transactional
public class DefaultGPSService implements GPSService {

    @Autowired
    private GPSRepository gpsRepository;

    @Override
    public List<GPSMeasurement> getAll() {
        return gpsRepository.findAll();
    }
}
