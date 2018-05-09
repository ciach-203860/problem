package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.MagneticMeasurement;

import java.util.List;

public interface MagneticService {

    List<MagneticMeasurement> getAll();

    void save(MagneticMeasurement temp);
}
