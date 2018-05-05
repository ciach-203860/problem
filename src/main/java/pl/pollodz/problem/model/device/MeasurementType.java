package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "measurement_types")
public class MeasurementType {

    @Id
    @GeneratedValue
    @Column(name = "measurement_type_id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "additional_information")
    private String additionalInformation;
}
