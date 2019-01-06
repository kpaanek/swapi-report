package pl.softwareplant.report.swapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.softwareplant.report.swapi.model.Film;
import pl.softwareplant.report.swapi.model.Person;
import pl.softwareplant.report.swapi.model.Planet;
import pl.softwareplant.report.swapi.model.SwApiResponse;
import pl.softwareplant.report.swapi.model.SwApiResult;
import pl.softwareplant.report.swapi.validator.SwApiResponseValidator;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class SwApiService {

    private final SwApiClient swApiClient;
    private final SwApiResponseValidator swApiResponseValidator;

    Person getPersonLikeName(String name) {
        return extractResult(swApiClient.getPeopleLikeName(name));
    }

    Planet getPlanetByName(String name) {
        return extractResult(swApiClient.getPlanetsByName(name));
    }

    Film getFilmByUrl(String url) {
        return swApiClient.getFilmByUrl(URI.create(url));
    }

    private <T extends SwApiResult> T extractResult(SwApiResponse<T> swApiResponse) {
        swApiResponseValidator.validate(swApiResponse);
        return swApiResponse.getResults().stream().findFirst().get();
    }
}