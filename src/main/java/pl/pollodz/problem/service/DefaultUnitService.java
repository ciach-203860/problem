package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollodz.problem.model.device.Unit;
import pl.pollodz.problem.repository.UnitRepository;

import java.util.Optional;

@Service
public class DefaultUnitService implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Optional<Unit> getByDescription(String description) {
        return Optional.ofNullable(unitRepository.findByDescription(description));
    }
}
