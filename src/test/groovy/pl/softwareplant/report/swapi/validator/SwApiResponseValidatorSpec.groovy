package pl.softwareplant.report.swapi.validator

import pl.softwareplant.report.swapi.model.SwApiResponse
import spock.lang.Specification
import spock.lang.Unroll

class SwApiResponseValidatorSpec extends Specification {

    def swapiResponseValidator = new SwApiResponseValidator()

    def "should do nothing if response count is valid"() {
        given:
            def response = new SwApiResponse(
                    count: 1
            )
        when:
            swapiResponseValidator.validate(response)
        then:
            noExceptionThrown()
    }

    @Unroll
    def "should throw exception if response count is invalid"() {
        given:
            def response = new SwApiResponse(
                    count: invalidCount
            )
        when:
            swapiResponseValidator.validate(response)
        then:
            thrown(RuntimeException)
        where:
            invalidCount << [0, 2]
    }
}
