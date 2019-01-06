package pl.softwareplant.report.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.softwareplant.report.exception.dto.ServerSideErrorDto;

import java.util.UUID;

@Slf4j
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerSideErrorDto handleRuntimeException(RuntimeException exception) {
        return getServerSideErrorDto(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerSideErrorDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return getServerSideErrorDto(exception);
    }

    private ServerSideErrorDto getServerSideErrorDto(Exception exception) {
        var serverSideErrorDto = new ServerSideErrorDto(UUID.randomUUID());
        log.error(serverSideErrorDto.getUuid().toString(), exception);
        return serverSideErrorDto;
    }
}