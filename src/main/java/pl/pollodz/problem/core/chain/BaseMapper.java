package pl.pollodz.problem.core.chain;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.pollodz.problem.model.device.Device;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.response.Measurement;

@AllArgsConstructor
@Slf4j
public abstract class BaseMapper {

    private BaseMapper baseMapper;

    private MeasurementType measurementType;

    public BaseMapper setBaseMapper(BaseMapper baseMapper) {
        this.baseMapper = baseMapper;
        return this;
    }

    public void handleMeasurement(Measurement measurement, Device device) {

        if (baseMapper != null) {
            baseMapper.handleMeasurement(measurement, device);
        } else {
            if (log.isErrorEnabled()) {
                log.error("Measurement processing for " + measurement + " failed.");
            }
        }
    }

    protected boolean canHandleMeasurement(Device device) {
        return measurementType == device.getMeasurementType();
    }
}
