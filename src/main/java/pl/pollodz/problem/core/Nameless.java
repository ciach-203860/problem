package pl.pollodz.problem.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.pollodz.problem.response.Measurement;
import pl.pollodz.problem.response.MeasurementsList;

@Service
@Slf4j
public class Nameless {

    // TODO refactor, this class is only for tests

    public void nameless(MeasurementsList list) {

        for (Measurement measurement : list.getMeasurements()) {

            try {

                // TODO logic

            } catch (Exception exception) {
                if (log.isErrorEnabled()) {
                    log.error("Measurement processing for " + measurement + " failed.", exception);
                }
            }
        }
    }
}
