package pl.pollodz.problem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pollodz.problem.model.device.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByName(String name);
}
