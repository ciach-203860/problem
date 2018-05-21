package pl.pollodz.problem.corerefactored;

import lombok.Data;
import pl.pollodz.problem.model.device.Device;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Table(name = "mappers")
public class MapperRefactored {

    @Id
    @GeneratedValue
    @Column(name = "mapper_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(cascade = ALL)
    @JoinTable(name = "mappers_devices",
            joinColumns = @JoinColumn(name = "mapper_id"),
            inverseJoinColumns = @JoinColumn(name = "device_id"))
    private List<Device> devices = new ArrayList<>();
}
