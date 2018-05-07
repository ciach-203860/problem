package pl.pollodz.problem.service;

import pl.pollodz.problem.model.device.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceService {

    Optional<Device> getByName(String name);

    List<Device> getAll();
}
