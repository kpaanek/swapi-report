package pl.softwareplant.report.command;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.softwareplant.report.api.ReportCommandEndpoint;
import pl.softwareplant.report.api.dto.ReportCriteriaDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ReportCommandController implements ReportCommandEndpoint {

    private final ReportCommandFacade reportCommandFacade;

    @Override
    public void generateReport(@Valid @RequestBody ReportCriteriaDto reportCriteriaDto) {
        reportCommandFacade.generateReport(reportCriteriaDto);
    }

    @Override
    public void deleteReport() {
        reportCommandFacade.deleteReport();
    }
}
