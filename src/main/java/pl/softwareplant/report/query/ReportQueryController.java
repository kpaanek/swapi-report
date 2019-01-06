package pl.softwareplant.report.query;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import pl.softwareplant.report.api.ReportQueryEndpoint;
import pl.softwareplant.report.api.dto.ReportSummaryDto;

@RestController
@RequiredArgsConstructor
public class ReportQueryController implements ReportQueryEndpoint {

    private final ReportQueryService reportQueryService;

    @Override
    public ReportSummaryDto getReportResult() {
        return reportQueryService.getReportResult();
    }
}