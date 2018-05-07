package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.HumidityMeasurement;

import java.util.List;

public interface HumidityService {

    List<HumidityMeasurement> getAll();
}
