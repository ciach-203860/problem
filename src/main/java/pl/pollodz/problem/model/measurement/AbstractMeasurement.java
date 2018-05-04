package pl.pollodz.problem.model.measurement;

import lombok.Data;
import pl.pollodz.problem.model.device.Device;

@Data
public class AbstractMeasurement {

    private Device device;

    private Object measurement;
}
