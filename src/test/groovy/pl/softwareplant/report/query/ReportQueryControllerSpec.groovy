package pl.softwareplant.report.query

import pl.softwareplant.report.api.dto.ReportCriteriaDto
import pl.softwareplant.report.api.dto.ReportDto
import pl.softwareplant.report.api.dto.ReportSummaryDto
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class ReportQueryControllerSpec extends Specification {

    def reportQueryServiceMock = Mock(ReportQueryService)
    def reportQueryController = new ReportQueryController(reportQueryServiceMock)

    def mockMvc = standaloneSetup(reportQueryController).build()

    def "should return OK and ReportResultDto object when getReportResult is called"() {
        given:
            def reportSummaryDto = createReportSummaryDto()
        and:
            reportQueryServiceMock.getReportResult() >> reportSummaryDto
        when:
            def result = mockMvc.perform(get('/report'))
        then:
            result.andExpect(status().isOk())
                    .andExpect(jsonPath('$.criteria.characterPhrase').value(reportSummaryDto.criteria.characterPhrase))
                    .andExpect(jsonPath('$.criteria.planetName').value(reportSummaryDto.criteria.planetName))
                    .andExpect(jsonPath('$.result.film_id').value(reportSummaryDto.result.filmId))
                    .andExpect(jsonPath('$.result.film_name').value(reportSummaryDto.result.filmName))
                    .andExpect(jsonPath('$.result.character_id').value(reportSummaryDto.result.characterId))
                    .andExpect(jsonPath('$.result.character_name').value(reportSummaryDto.result.characterName))
                    .andExpect(jsonPath('$.result.planet_id').value(reportSummaryDto.result.planetId))
                    .andExpect(jsonPath('$.result.planet_name').value(reportSummaryDto.result.planetName))
    }

    def createReportSummaryDto() {
        ReportSummaryDto.builder()
                .criteria(new ReportCriteriaDto(
                    'characterPhrase': 'Leia',
                    'planetName': 'Alderaan'
                ))
                .result(ReportDto.builder()
                    .characterId('5')
                    .characterName('Leia Organa')
                    .planetId('2')
                    .planetName('Alderaan')
                    .filmId('6')
                    .filmName('Revenge of the Sith')
                    .build()
                ).build()
    }
}