package pl.pollodz.problem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pollodz.problem.dto.DeviceDto;
import pl.pollodz.problem.dto.UniversalMeasurementDto;
import pl.pollodz.problem.dto.converter.DateConverter;
import pl.pollodz.problem.dto.converter.DeviceConverter;
import pl.pollodz.problem.dto.converter.UniversalConverter;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.repository.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional
public class DefaultDeviceService implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private TemperatureRepository temperatureRepository;

    @Autowired
    private MagneticRepository magneticRepository;

    @Autowired
    private LightingRepository lightingRepository;

    @Autowired
    private HumidityRepository humidityRepository;

    @Autowired
    private GPSRepository gpsRepository;

    @Autowired
    private DistanceRepository distanceRepository;

    @Autowired
    private DetectionRepository detectionRepository;

    @Override
    public Optional<Device> getByName(String name) {
        return Optional.ofNullable(deviceRepository.findByName(name));
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public List<DeviceDto> getAllDevices() {
        return deviceRepository.findAll()
                .stream()
                .map(DeviceConverter::toDeviceDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Device> getById(Long id) {
        return deviceRepository.findById(id);
    }


    @Override
    public List<UniversalMeasurementDto> getMeasuermentsForDevices(Date start, Date end, long deviceId) {
        Device device = deviceRepository.findById(deviceId).get();
        MeasurementType measurementType = device.getMeasurementType();
        if(start == null || end == null){
            Calendar startC = Calendar.getInstance();
            startC.setTimeInMillis(0);
            Calendar endC = Calendar.getInstance();
            endC.setTimeInMillis(Long.MAX_VALUE/10000);
            start = startC.getTime();
            end = endC.getTime();
        }

        switch (measurementType) {
            case TEMPERATURE:
                return temperatureRepository.getTemperatureMeasurementsFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
            case AZIMUTH:
                return magneticRepository.getMagneticMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
            case DISTANCE:
                return distanceRepository.getDistanceMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
            case HUMIDITY:
                return humidityRepository.getHumidityMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
            case LIGHTING:
                return lightingRepository.getLightingMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
            case MOTION_ANALYSIS:
                return gpsRepository.getGPSMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
            case MOTION_DETECTION:
                return detectionRepository.getDetectionMeasurementFromPeriodOfTime(DateConverter.toLocalDataTime(start), DateConverter.toLocalDataTime(end), deviceId)
                        .stream()
                        .map(UniversalConverter::toUniversalMeasurementDto)
                        .collect(Collectors.toList());
                default:

        }
        return new ArrayList<>();
    }
}
