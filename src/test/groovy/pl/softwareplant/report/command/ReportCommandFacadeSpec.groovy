package pl.softwareplant.report.command

import pl.softwareplant.report.api.dto.ReportCriteriaDto
import pl.softwareplant.report.command.factory.ReportCriteriaFactory
import pl.softwareplant.report.domain.model.ReportCriteria
import pl.softwareplant.report.swapi.SwApiFacade
import spock.lang.Specification

class ReportCommandFacadeSpec extends Specification {

    def swApiFacadeMock = Mock(SwApiFacade)
    def reportCriteriaFactoryMock = Mock(ReportCriteriaFactory)
    def reportCommandService = Mock(ReportCommandService)
    def reportCommandFacade = new ReportCommandFacade(swApiFacadeMock, reportCriteriaFactoryMock, reportCommandService)

    def "should call service method generateReport with correct argument when given correct dto"() {
        given:
            def reportCriteriaDto = new ReportCriteriaDto(
                    characterPhrase: 'Leia',
                    planetName: 'Alderaan'
            )
        and:
            def results = []
            swApiFacadeMock.getSearchResult(reportCriteriaDto.getCharacterPhrase(), reportCriteriaDto.planetName) >> results
        and:
            def reportCriteriaMock = Mock(ReportCriteria)
            reportCriteriaFactoryMock.create(reportCriteriaDto, results) >> reportCriteriaMock
        when:
            reportCommandFacade.generateReport(reportCriteriaDto)
        then:
            1 * reportCommandService.generateReport(reportCriteriaMock)
    }

    def "should call service method deleteReport"() {
        when:
            reportCommandFacade.deleteReport()
        then:
            1 * reportCommandService.deleteReport()
    }
}
