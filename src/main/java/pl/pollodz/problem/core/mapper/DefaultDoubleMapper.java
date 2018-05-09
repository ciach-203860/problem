package pl.pollodz.problem.core.mapper;

public class DefaultDoubleMapper implements DoubleMapper {

    @Override
    public Double map(String input) {
        return Double.parseDouble(input); // XD
    }
}
