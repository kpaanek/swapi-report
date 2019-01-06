package pl.softwareplant.report.swapi

import pl.softwareplant.report.swapi.model.Film
import pl.softwareplant.report.swapi.model.Person
import pl.softwareplant.report.swapi.model.Planet
import spock.lang.Specification

class SwApiFacadeSpec extends Specification {

    def swApiServiceMock = Mock(SwApiService)
    def swApiFacade = new SwApiFacade(swApiServiceMock)

    def "should return SwApi result for correct searched criteria"() {
        given:
            def characterPhrase = "Leia"
            def planetName = "Alderaan"
            def mutualFilmUrl = 'https://swapi.co/api/films/6/'
        and:
            def person = new Person(
                    filmUrls: [
                            'https://swapi.co/api/films/3/',
                            mutualFilmUrl
                    ]
            )
            swApiServiceMock.getPersonLikeName(characterPhrase) >> person
        and:
            def planet = new Planet(
                    filmUrls: [
                            mutualFilmUrl,
                            'https://swapi.co/api/films/2/'
                    ]
            )
            swApiServiceMock.getPlanetByName(planetName) >> planet
        and:
            def film = Mock(Film)
            swApiServiceMock.getFilmByUrl(mutualFilmUrl) >> film
        when:
            def searchResult = swApiFacade.getSearchResult(characterPhrase, planetName)
        then:
            searchResult.size() == 3
            searchResult.containsAll([person, planet, film])
    }

    def "should throw exception when planet and person dont have mutual film urls"() {
        given:
            def characterPhrase = "Luke Spockwalker"
            def planetName = "Groovy"
        and:
            def person = new Person(
                    filmUrls: [
                            'https://swapi.co/api/films/3/',
                            'https://swapi.co/api/films/4/'
                    ]
            )
            swApiServiceMock.getPersonLikeName(characterPhrase) >> person
        and:
            def planet = new Planet(
                filmUrls: [
                        'https://swapi.co/api/films/1/',
                        'https://swapi.co/api/films/2/'
                ]
            )
            swApiServiceMock.getPlanetByName(planetName) >> planet
        when:
            swApiFacade.getSearchResult(characterPhrase, planetName)
        then:
            thrown(RuntimeException)
    }
}
