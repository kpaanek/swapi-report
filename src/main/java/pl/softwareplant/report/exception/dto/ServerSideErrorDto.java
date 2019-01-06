package pl.softwareplant.report.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class ServerSideErrorDto {
    private UUID uuid;
}
