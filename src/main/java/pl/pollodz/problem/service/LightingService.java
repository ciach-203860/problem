package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.LightingMeasurement;

import java.util.List;

public interface LightingService {

    List<LightingMeasurement> getAll();
}
