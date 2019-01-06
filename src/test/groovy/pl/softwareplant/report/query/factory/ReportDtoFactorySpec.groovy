package pl.softwareplant.report.query.factory

import pl.softwareplant.report.domain.model.Report
import pl.softwareplant.report.domain.model.ReportPrimaryKey
import spock.lang.Specification

class ReportDtoFactorySpec extends Specification {

    def reportDtoFactory = new ReportDtoFactory()

    def "should create ReportDto from entity"() {
        given:
            def report = createReport()
        when:
            def result = reportDtoFactory.create(report)
        then:
            result.filmId == report.reportPrimaryKey.filmId
            result.filmName == report.filmName
            result.characterId == report.reportPrimaryKey.characterId
            result.characterName == report.characterName
            result.planetId == report.reportPrimaryKey.planetId
            report.planetName == report.planetName
    }

    def createReport() {
        new Report(
                reportPrimaryKey: new ReportPrimaryKey(
                        filmId: '6',
                        characterId: '5',
                        planetId: '2',
                ),
                filmName: 'Revenge of the Sith',
                characterName: 'Leia Organa',
                planetName: 'Alderaan'
        )
    }
}
