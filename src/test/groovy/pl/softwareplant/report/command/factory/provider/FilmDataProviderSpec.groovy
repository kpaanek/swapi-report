package pl.softwareplant.report.command.factory.provider

import pl.softwareplant.report.domain.model.Report
import pl.softwareplant.report.domain.model.ReportPrimaryKey
import pl.softwareplant.report.swapi.model.Film
import spock.lang.Specification

class FilmDataProviderSpec extends Specification {

    def filmDataProvider = new FilmDataProvider()

    def "should getSupportedClass return Film class" () {
        expect:
            Film.class == filmDataProvider.getSupportedClass()
    }

    def "should provide film data for report"() {
        given:
            def film = new Film(
                    title: 'Revenge of the Sith',
                    url: 'https://swapi.co/api/films/6/'
            )
        and:
            def report = new Report(
                    reportPrimaryKey: new ReportPrimaryKey()
            )
        when:
            filmDataProvider.provideData(report, film)
        then:
            report.filmName == film.name
            report.reportPrimaryKey.filmId == '6'
    }
}
