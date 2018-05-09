package pl.pollodz.problem.core.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultDateMapper implements DateMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime map(String input) {
        return LocalDateTime.parse(input, FORMATTER);
    }
}
