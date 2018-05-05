package pl.pollodz.problem.model.device;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "units")
public class Unit {

    @Id
    @GeneratedValue
    @Column(name = "unit_id")
    private Long id;

    @Column(name = "description")
    private String description;
}
