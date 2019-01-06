package pl.softwareplant.report.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.softwareplant.report.api.dto.ReportCriteriaDto;
import pl.softwareplant.report.command.factory.ReportCriteriaFactory;
import pl.softwareplant.report.swapi.SwApiFacade;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportCommandFacade {

    private final SwApiFacade swApiFacade;
    private final ReportCriteriaFactory reportCriteriaFactory;
    private final ReportCommandService reportCommandService;

    void generateReport(ReportCriteriaDto reportCriteriaDto) {
        var searchResult = swApiFacade.getSearchResult(reportCriteriaDto.getCharacterPhrase(), reportCriteriaDto.getPlanetName());
        reportCommandService.generateReport(reportCriteriaFactory.create(reportCriteriaDto, searchResult));
    }

    void deleteReport() {
        reportCommandService.deleteReport();
    }
}