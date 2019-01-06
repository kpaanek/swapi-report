package pl.softwareplant.report.swapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.softwareplant.report.swapi.model.Person;
import pl.softwareplant.report.swapi.model.Planet;
import pl.softwareplant.report.swapi.model.SwApiResult;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SwApiFacade {

    private final SwApiService swApiService;

    public List<SwApiResult> getSearchResult(String characterPhrase, String planetName) {
        var person = swApiService.getPersonLikeName(characterPhrase);
        var planet = swApiService.getPlanetByName(planetName);
        var film = swApiService.getFilmByUrl(intersectPlanetAndPersonFilmUrls(person, planet));
        return List.of(person, planet, film);
    }

    private String intersectPlanetAndPersonFilmUrls(Person person, Planet planet) {
        return person.getFilmUrls().stream()
                .filter(planet.getFilmUrls()::contains)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("At least one film url must be present."));
    }
}
