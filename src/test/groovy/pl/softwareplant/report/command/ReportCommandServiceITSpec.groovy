package pl.softwareplant.report.command

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import pl.softwareplant.report.domain.ReportCriteriaRepository
import pl.softwareplant.report.domain.model.Report
import pl.softwareplant.report.domain.model.ReportCriteria
import pl.softwareplant.report.domain.model.ReportPrimaryKey
import spock.lang.Specification

@Sql("/sql/insert_report_criteria.sql")
@SpringBootTest
@ActiveProfiles("test")
class ReportCommandServiceITSpec extends Specification {

    @Autowired
    ReportCommandService reportCommandService

    @Autowired
    ReportCriteriaRepository reportCriteriaRepository

    def "should generate report"() {
        given:
            def reportCriteria = createReportCriteria()
        when:
            reportCommandService.generateReport(reportCriteria)
        then:
            def reportCriteriaList = reportCriteriaRepository.findAll()
            reportCriteriaList.size() == 1
            reportCriteriaList[0] == reportCriteria
    }

    def "should delete report"() {
        when:
            reportCommandService.deleteReport()
        then:
            reportCriteriaRepository.findAll() == []
    }

    def createReportCriteria() {
        new ReportCriteria(
                characterPhrase: 'Leia',
                planetName: 'Alderaan',
                report: new Report(
                        reportPrimaryKey: new ReportPrimaryKey(
                                filmId: '6',
                                characterId: '5',
                                planetId: '2',
                        ),
                        filmName: 'Revenge of the Sith',
                        characterName: 'Leia Organa',
                        planetName: 'Alderaan'
                )
        )
    }
}
