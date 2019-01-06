package pl.softwareplant.report.command

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import pl.softwareplant.report.api.dto.ReportCriteriaDto
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class ReportCommandControllerSpec extends Specification {

    def reportCommandFacadeMock = Mock(ReportCommandFacade)
    def reportCommandController = new ReportCommandController(reportCommandFacadeMock)

    def mockMvc = standaloneSetup(reportCommandController).build()

    def "should return OK when generateReport is called with given criteria"() {
        given:
            def reportCriteriaDto = new ReportCriteriaDto(
                    characterPhrase: 'Leia',
                    planetName: 'Alderaan'
            )
        when:
            def result = mockMvc.perform(put('/report')
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsBytes(reportCriteriaDto)))
        then:
            result.andExpect(status().isOk())
    }

    def "should return OK when deleteReport is called"() {
        expect:
            mockMvc.perform(delete('/report')).andExpect(status().isOk())
    }
}
