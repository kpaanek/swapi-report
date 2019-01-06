package pl.softwareplant.report.command.factory.provider

import pl.softwareplant.report.domain.model.Report
import pl.softwareplant.report.domain.model.ReportPrimaryKey
import pl.softwareplant.report.swapi.model.Planet
import spock.lang.Specification

class PlanetDataProviderSpec extends Specification {

    def planetDataProvider = new PlanetDataProvider()

    def "should getSupportedClass return Planet class" () {
        expect:
            Planet.class == planetDataProvider.getSupportedClass()
    }

    def "should provide planet data for report"() {
        given:
            def planet = new Planet(
                    name: 'Alderaan',
                    url: 'https://swapi.co/api/planets/2/'
            )
        and:
            def report = new Report(
                    reportPrimaryKey: new ReportPrimaryKey()
            )
        when:
            planetDataProvider.provideData(report, planet)
        then:
            report.planetName == planet.name
            report.reportPrimaryKey.planetId == '2'
    }
}
