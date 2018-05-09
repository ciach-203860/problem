package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.GPSMeasurement;

import java.util.List;

public interface GPSService {

    List<GPSMeasurement> getAll();

    void save(GPSMeasurement temp);
}
