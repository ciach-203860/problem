package pl.pollodz.problem.dto.converter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateConverter {
    public static LocalDateTime toLocalDataTime(Date date){
        return LocalDateTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
    }
}
