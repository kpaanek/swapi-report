package pl.softwareplant.report.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.softwareplant.report.api.dto.ReportSummaryDto;
import pl.softwareplant.report.domain.ReportCriteriaRepository;
import pl.softwareplant.report.query.factory.ReportSummaryDtoFactory;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportQueryService {

    private final ReportCriteriaRepository reportCriteriaRepository;
    private final ReportSummaryDtoFactory reportSummaryDtoFactory;

    ReportSummaryDto getReportResult() {
        return reportSummaryDtoFactory.create(reportCriteriaRepository.findFirstBy());
    }
}
