package pl.pollodz.problem.model.device;

import lombok.Data;

@Data
public class Device {

    private String deviceId;

    private MeasurementType measurementType;

    private Unit unit;
}
