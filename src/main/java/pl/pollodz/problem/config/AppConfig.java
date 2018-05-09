package pl.pollodz.problem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pollodz.problem.core.mapper.*;
import pl.pollodz.problem.core.translator.FahrenheitToCelsiusTemperatureTranslator;
import pl.pollodz.problem.core.translator.TemperatureTranslator;

@Configuration
public class AppConfig {

    @Bean
    public DoubleMapper doubleMapper() {
        return new DefaultDoubleMapper();
    }

    @Bean
    public CoordinateMapper coordinateMapper() {
        return new DefaultCoordinateMapper();
    }

    @Bean
    public TemperatureTranslator temperatureTranslator() {
        return new FahrenheitToCelsiusTemperatureTranslator();
    }

    @Bean
    public DateMapper dateMapper() {
        return new DefaultDateMapper();
    }
}
