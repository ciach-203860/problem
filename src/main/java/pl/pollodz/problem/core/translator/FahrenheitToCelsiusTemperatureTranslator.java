package pl.pollodz.problem.core.translator;

public class FahrenheitToCelsiusTemperatureTranslator implements TemperatureTranslator {

    private static final Double CONSTANT = 32.0;

    private static final Double MULTIPLIER = 0.5555;

    @Override
    public Double translate(Double input) {
        return (input - CONSTANT) * MULTIPLIER;
    }
}
