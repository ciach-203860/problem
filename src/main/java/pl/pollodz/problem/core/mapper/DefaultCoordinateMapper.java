package pl.pollodz.problem.core.mapper;

import pl.pollodz.problem.model.measurement.additional.Coordinate;

public class DefaultCoordinateMapper implements CoordinateMapper {

    @Override
    public Coordinate map(String input) {
        String[] temp = input.split(",");
        return Coordinate.builder()
                .latitude(Double.parseDouble(temp[0]))
                .longitude(Double.parseDouble(temp[1]))
                .build();
    }
}
