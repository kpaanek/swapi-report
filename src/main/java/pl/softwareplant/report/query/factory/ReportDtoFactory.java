package pl.softwareplant.report.query.factory;

import org.springframework.stereotype.Component;
import pl.softwareplant.report.api.dto.ReportDto;
import pl.softwareplant.report.domain.model.Report;
import pl.softwareplant.report.domain.model.ReportPrimaryKey;

@Component
public class ReportDtoFactory {

    ReportDto create(Report report) {
        var reportPrimaryKey = report.getReportPrimaryKey();
        return ReportDto.builder()
                .characterId(reportPrimaryKey.getCharacterId())
                .characterName(report.getCharacterName())
                .filmId(reportPrimaryKey.getFilmId())
                .filmName(report.getFilmName())
                .planetId(reportPrimaryKey.getPlanetId())
                .planetName(report.getPlanetName())
                .build();
    }
}
