package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity(name = "devices")
public class Device {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private Long id;

    @Column(name = "custom_id", unique = true)
    private String deviceId;

    @JoinColumn(name = "measurement_type_id")
    @ManyToOne(cascade = ALL, fetch = LAZY)
    private MeasurementType measurementType;

    @ManyToOne(cascade = ALL, fetch = LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
