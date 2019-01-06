package pl.softwareplant.report.query.factory

import org.dozer.DozerBeanMapper
import pl.softwareplant.report.api.dto.ReportDto
import pl.softwareplant.report.domain.model.Report
import pl.softwareplant.report.domain.model.ReportCriteria
import spock.lang.Specification

class ReportSummaryDtoFactorySpec extends Specification {

    def dozerBeanMapperSpy = Spy(DozerBeanMapper)
    def reportDtoFactoryMock = Mock(ReportDtoFactory)
    def reportSummaryDtoFactory = new ReportSummaryDtoFactory(dozerBeanMapperSpy, reportDtoFactoryMock)

    def "should return null when reportCriteria is null"() {
        expect:
            reportSummaryDtoFactory.create(null) == null
    }

    def "should create reportSummaryDto from reportCriteria"() {
        given:
            def reportMock = Mock(Report)
            def reportCriteria = new ReportCriteria(
                    characterPhrase: 'Leia',
                    planetName: 'Alderaan',
                    report: reportMock
            )
        and:
            def reportDtoMock = Mock(ReportDto)
            reportDtoFactoryMock.create(reportMock) >> reportDtoMock
        when:
            def result = reportSummaryDtoFactory.create(reportCriteria)
        then:
            result.criteria.planetName == reportCriteria.planetName
            result.criteria.characterPhrase == reportCriteria.characterPhrase
            result.result == reportDtoMock
    }
}
