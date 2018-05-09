package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Data
@Entity(name = "devices")
public class Device {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Enumerated(STRING)
    @Column(name = "measurement_type")
    private MeasurementType measurementType;

    @Enumerated(STRING)
    @Column(name = "unit")
    private Unit unit;

    @Column(name = "description_key")
    private String descriptionKey;
}
