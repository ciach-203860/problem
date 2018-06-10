package pl.pollodz.problem.core.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultDateMapper implements DateMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");

    @Override
    public LocalDateTime map(String input) {
        return LocalDateTime.parse(input, FORMATTER);
    }
}
