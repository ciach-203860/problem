package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Unit {

    @Column(name = "unit")
    private String unit;
}
