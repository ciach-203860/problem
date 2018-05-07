package pl.pollodz.problem.model.measurement;

import lombok.Data;
import pl.pollodz.problem.model.device.Device;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@MappedSuperclass
@Data
public class AbstractMeasurement {

    @Id
    @GeneratedValue
    @Column(name = "measurement_id")
    private Long id;

    @JoinColumn(name = "device_id")
    @ManyToOne(cascade = ALL, fetch = LAZY)
    private Device device;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;
}
