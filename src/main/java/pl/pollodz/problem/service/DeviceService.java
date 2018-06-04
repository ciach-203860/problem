package pl.pollodz.problem.service;

import pl.pollodz.problem.dto.DeviceDto;
import pl.pollodz.problem.dto.UniversalMeasurementDto;
import pl.pollodz.problem.model.device.Device;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DeviceService {

    Optional<Device> getByName(String name);

    List<Device> getAll();

    List<DeviceDto> getAllDevices();

    Optional<Device> getById(Long id);

    List<UniversalMeasurementDto> getMeasuermentsForDevices(Date start, Date end, long deviceId);
}
