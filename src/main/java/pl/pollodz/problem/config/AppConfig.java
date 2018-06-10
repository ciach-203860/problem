package pl.pollodz.problem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import pl.pollodz.problem.core.chain.*;
import pl.pollodz.problem.core.mapper.*;
import pl.pollodz.problem.core.translator.FahrenheitToCelsiusTemperatureTranslator;
import pl.pollodz.problem.core.translator.TemperatureTranslator;
import pl.pollodz.problem.model.device.MeasurementType;
import pl.pollodz.problem.service.JsonResponse;

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

    @Bean
    public TemperatureMapper temperatureMapper() {
        return new TemperatureMapper(null, MeasurementType.TEMPERATURE);
    }

    @Bean
    public AzimuthMapper azimuthMapper() {
        return new AzimuthMapper(null, MeasurementType.AZIMUTH);
    }

    @Bean
    public DistanceMapper distanceMapper() {
        return new DistanceMapper(null, MeasurementType.DISTANCE);
    }

    @Bean
    public HumidityMapper humidityMapper() {
        return new HumidityMapper(null, MeasurementType.HUMIDITY);
    }

    @Bean
    public LightingMapper lightingMapper() {
        return new LightingMapper(null, MeasurementType.LIGHTING);
    }

    @Bean
    public MotionDetectionMapper motionDetectionMapper() {
        return new MotionDetectionMapper(null, MeasurementType.MOTION_DETECTION);
    }

    @Bean
    public MotionAnalysisMapper motionAnalysisMapper() {
        return new MotionAnalysisMapper(null, MeasurementType.MOTION_ANALYSIS);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new SimpleClientHttpRequestFactory());
    }

    @Bean
    public JsonResponse jsonResponse(){
        return new JsonResponse();
    }
}
