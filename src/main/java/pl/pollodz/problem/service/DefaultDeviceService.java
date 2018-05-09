package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultDeviceService implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Optional<Device> getByName(String name) {
        return Optional.ofNullable(deviceRepository.findByName(name));
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> getById(Long id) {
        return deviceRepository.findById(id);
    }
}
