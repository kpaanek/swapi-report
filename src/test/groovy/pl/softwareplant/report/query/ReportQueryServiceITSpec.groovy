package pl.softwareplant.report.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import spock.lang.Specification

@Sql("/sql/insert_report_criteria.sql")
@SpringBootTest
@ActiveProfiles("test")
class ReportQueryServiceITSpec extends Specification {

    @Autowired
    ReportQueryService reportQueryService

    def "should return reportResult"() {
        when:
            def reportResult = reportQueryService.getReportResult()
        then:
            reportResult.result != null
            reportResult.criteria != null
    }
}
