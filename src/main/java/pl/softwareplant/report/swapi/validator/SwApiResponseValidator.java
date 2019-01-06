package pl.softwareplant.report.swapi.validator;

import org.springframework.stereotype.Component;
import pl.softwareplant.report.swapi.model.SwApiResponse;

@Component
public class SwApiResponseValidator {

    private static final int RECORD_COUNT_LIMIT = 1;

    public void validate(SwApiResponse swapiResponse) {
        if (RECORD_COUNT_LIMIT != swapiResponse.getCount()) {
            throw new IllegalArgumentException("Not valid count of results.");
        }
    }
}
