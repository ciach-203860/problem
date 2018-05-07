package pl.pollodz.problem.service;

import pl.pollodz.problem.model.measurement.TemperatureMeasurement;

import java.util.List;

public interface TemperatureService {

    List<TemperatureMeasurement> getAll();
}
