package pl.softwareplant.report.command.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.softwareplant.report.api.dto.ReportCriteriaDto;
import pl.softwareplant.report.domain.model.ReportCriteria;
import pl.softwareplant.report.swapi.model.SwApiResult;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReportCriteriaFactory {

    private final ReportFactory reportFactory;

    public ReportCriteria create(ReportCriteriaDto reportCriteriaDto, List<SwApiResult> swApiResults) {
        return ReportCriteria.builder()
                .report(reportFactory.create(swApiResults))
                .characterPhrase(reportCriteriaDto.getCharacterPhrase())
                .planetName(reportCriteriaDto.getPlanetName())
                .build();
    }
}
