package pl.softwareplant.report.swapi

import pl.softwareplant.report.swapi.model.Film
import pl.softwareplant.report.swapi.model.Person
import pl.softwareplant.report.swapi.model.Planet
import pl.softwareplant.report.swapi.model.SwApiResponse
import pl.softwareplant.report.swapi.validator.SwApiResponseValidator
import spock.lang.Specification

class SwApiServiceSpec extends Specification {

    def swApiClientMock = Mock(SwApiClient)
    def swApiResponseValidatorMock = Mock(SwApiResponseValidator)
    def swApiService = new SwApiService(swApiClientMock, swApiResponseValidatorMock)

    def "should extract person from service response"() {
        given:
            def personName = 'Leia'
        and:
            def person = Mock(Person)
            def swApiResponse = new SwApiResponse(
                    results: [ person ]
            )
        and:
            swApiClientMock.getPeopleLikeName(personName) >> swApiResponse
        expect:
            swApiService.getPersonLikeName(personName) == person
    }

    def "should extract planet from service response"() {
        given:
            def planetName = 'Yavin IV'
        and:
            def planet = Mock(Planet)
            def swApiResponse = new SwApiResponse(
                    results: [ planet ]
            )
        and:
            swApiClientMock.getPlanetsByName(planetName) >> swApiResponse
        expect:
            swApiService.getPlanetByName(planetName) == planet
    }

    def "should get film from service by url"() {
        given:
            def filmUrl = 'https://swapi.co/api/films/6/'
        and:
            def film = Mock(Film)
        and:
            swApiClientMock.getFilmByUrl(URI.create(filmUrl)) >> film
        expect:
            swApiService.getFilmByUrl(filmUrl) == film
    }
}