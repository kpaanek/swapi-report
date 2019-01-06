package pl.softwareplant.report.command.factory.provider

import pl.softwareplant.report.domain.model.Report
import pl.softwareplant.report.domain.model.ReportPrimaryKey
import pl.softwareplant.report.swapi.model.Person
import spock.lang.Specification

class PersonDataProviderSpec extends Specification {

    def personDataProvider = new PersonDataProvider()

    def "should getSupportedClass return Person class" () {
        expect:
            Person.class == personDataProvider.getSupportedClass()
    }

    def "should provide person data for report"() {
        given:
            def person = new Person(
                    name: 'Leia Organa',
                    url: 'https://swapi.co/api/people/5/'
            )
        and:
            def report = new Report(
                    reportPrimaryKey: new ReportPrimaryKey()
            )
        when:
            personDataProvider.provideData(report, person)
        then:
            report.characterName == person.name
            report.reportPrimaryKey.characterId == '5'
    }
}
