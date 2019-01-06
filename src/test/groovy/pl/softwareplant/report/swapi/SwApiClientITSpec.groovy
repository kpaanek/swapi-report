package pl.softwareplant.report.swapi

import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.apache.commons.io.IOUtils
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse
import static com.github.tomakehurst.wiremock.client.WireMock.get
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo

@SpringBootTest
@ActiveProfiles("test")
class SwApiClientITSpec extends Specification {

    @Autowired
    SwApiClient swApiClient

    @Rule
    WireMockRule wireMockRule = new WireMockRule(8089)

    @Value("classpath:responses\\get_planets.json")
    Resource getPlanetsResponse
    @Value("classpath:responses\\get_people.json")
    Resource getPeopleResponse
    @Value("classpath:responses\\get_film.json")
    Resource getFilmResponse

    def "should GET valid response from planets endpoint"() {
        given:
            def planetName = 'Yavin'
        and:
            def planetsResponse = resourceToString(getPlanetsResponse)
            wireMockRule.stubFor(get(urlEqualTo("/planets?search=$planetName"))
                            .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader('Content-Type', MediaType.APPLICATION_JSON_VALUE)
                            .withBody(planetsResponse)))
        when:
            def resultResponse = swApiClient.getPlanetsByName(planetName)
        then:
            resultResponse.count == 1
            resultResponse.results[0].name == planetName
    }

    def "should GET valid response from people endpoint"() {
        given:
            def personName = 'Luke'
        and:
            def peopleResponse = resourceToString(getPeopleResponse)
            wireMockRule.stubFor(get(urlEqualTo("/people?search=$personName"))
                    .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader('Content-Type', MediaType.APPLICATION_JSON_VALUE)
                    .withBody(peopleResponse)))
        when:
            def resultResponse = swApiClient.getPeopleLikeName(personName)
        then:
            resultResponse.count == 1
            resultResponse.results[0].name.contains(personName)
    }

    def "should GET valid response from film endpoint"() {
        given:
            def filmUrl = 'http://localhost:8089/films/6'
        and:
            def filmResponse = resourceToString(getFilmResponse)
            wireMockRule.stubFor(get(urlEqualTo('/films/6'))
                    .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                    .withBody(filmResponse)))
        when:
            def resultResponse = swApiClient.getFilmByUrl(URI.create(filmUrl))
        then:
            resultResponse.url == filmUrl
    }

    def resourceToString(resource) {
        IOUtils.toString(resource.getInputStream(), "UTF-8")
    }
}
