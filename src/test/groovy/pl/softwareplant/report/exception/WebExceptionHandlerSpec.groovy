package pl.softwareplant.report.exception

import org.springframework.web.bind.MethodArgumentNotValidException
import spock.lang.Specification

class WebExceptionHandlerSpec extends Specification {

    def webExceptionHandler = new WebExceptionHandler()

    def "should return ServerSideErrorDto when exception is MethodArgumentNotValidException"() {
        given:
            def exception = Mock(MethodArgumentNotValidException)
        expect:
            webExceptionHandler.handleMethodArgumentNotValidException(exception) != null
    }

    def "should return ServerSideErrorDto when exception is RuntimeException"() {
        given:
            def exception = Mock(RuntimeException)
        expect:
            webExceptionHandler.handleRuntimeException(exception) != null
    }
}
