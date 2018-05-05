package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.repository.MeasurementTypeRepository;

import java.util.Optional;

@Service
public class DefaultMeasurementTypeService implements MeasurementTypeService {

    @Autowired
    private MeasurementTypeRepository measurementTypeRepository;

    @Override
    public Optional<MeasurementType> getByDescription(String description) {
        return Optional.ofNullable(measurementTypeRepository.findByDescription(description));
    }
}
