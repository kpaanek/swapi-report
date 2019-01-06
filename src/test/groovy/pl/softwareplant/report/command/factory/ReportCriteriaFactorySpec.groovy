package pl.softwareplant.report.command.factory

import pl.softwareplant.report.api.dto.ReportCriteriaDto
import pl.softwareplant.report.domain.model.Report
import spock.lang.Specification

class ReportCriteriaFactorySpec extends Specification {

    def reportFactoryMock = Mock(ReportFactory)
    def reportCriteriaFactory = new ReportCriteriaFactory(reportFactoryMock)

    def "should create ReportCriteria entity from dto and swapi results"() {
        given:
            def reportCriteriaDto = new ReportCriteriaDto(
                    characterPhrase: 'Leia',
                    planetName: 'Alderaan'
            )
            def swApiResults = []
        and:
            def reportMock = Mock(Report)
            reportFactoryMock.create(swApiResults) >> reportMock
        when:
            def result = reportCriteriaFactory.create(reportCriteriaDto, swApiResults)
        then:
            result.report == reportMock
            result.characterPhrase == reportCriteriaDto.characterPhrase
            result.planetName == reportCriteriaDto.planetName
    }
}
