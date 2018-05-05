package pl.pollodz.problem.service;

import pl.pollodz.problem.model.device.MeasurementType;

import java.util.Optional;

public interface MeasurementTypeService {

    Optional<MeasurementType> getByDescription(String description);
}
