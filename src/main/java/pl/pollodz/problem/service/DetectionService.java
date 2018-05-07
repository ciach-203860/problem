package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.DetectionMeasurement;

import java.util.List;

public interface DetectionService {

    List<DetectionMeasurement> getAll();
}
