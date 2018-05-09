package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.DistanceMeasurement;

import java.util.List;

public interface DistanceService {

    List<DistanceMeasurement> getAll();

    void save(DistanceMeasurement temp);
}
