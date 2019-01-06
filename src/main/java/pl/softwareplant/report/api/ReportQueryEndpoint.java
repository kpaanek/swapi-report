package pl.softwareplant.report.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.softwareplant.report.api.dto.ReportSummaryDto;

@RequestMapping(value = "/report")
public interface ReportQueryEndpoint {

    @GetMapping
    ReportSummaryDto getReportResult();
}
