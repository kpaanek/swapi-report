package pl.softwareplant.report.swapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.softwareplant.report.swapi.model.Film;
import pl.softwareplant.report.swapi.model.Person;
import pl.softwareplant.report.swapi.model.Planet;
import pl.softwareplant.report.swapi.model.SwApiResponse;

import java.net.URI;

@FeignClient(name = "swapi-client", url = "${swapi.url}", configuration = SwApiClientConfiguration.class)
public interface SwApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "people?search={name}")
    SwApiResponse<Person> getPeopleLikeName(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET, value = "planets?search={name}")
    SwApiResponse<Planet> getPlanetsByName(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET)
    Film getFilmByUrl(URI filmUrl);
}
