package pl.pollodz.problem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pollodz.problem.core.mapper.CoordinateMapper;
import pl.pollodz.problem.core.mapper.DefaultCoordinateMapper;
import pl.pollodz.problem.core.mapper.DefaultDoubleMapper;
import pl.pollodz.problem.core.mapper.DoubleMapper;
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
}
