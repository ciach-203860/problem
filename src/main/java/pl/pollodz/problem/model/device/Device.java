package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "devices")
public class Device {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    private MeasurementType measurementType;

    private Unit unit;
}
