package pl.pollodz.problem.service;

import pl.pollodz.problem.model.device.Unit;

import java.util.Optional;

public interface UnitService {

    Optional<Unit> getByDescription(String description);
}
