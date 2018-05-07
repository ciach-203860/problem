package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class MeasurementType {

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;
}
