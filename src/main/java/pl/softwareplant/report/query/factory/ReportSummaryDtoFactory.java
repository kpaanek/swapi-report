package pl.softwareplant.report.query.factory;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;
import pl.softwareplant.report.api.dto.ReportCriteriaDto;
import pl.softwareplant.report.api.dto.ReportSummaryDto;
import pl.softwareplant.report.domain.model.ReportCriteria;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReportSummaryDtoFactory {

    private final DozerBeanMapper dozerBeanMapper;
    private final ReportDtoFactory reportDtoFactory;

    public ReportSummaryDto create(ReportCriteria reportCriteria) {
        return Optional.ofNullable(reportCriteria).map(this::createReportSummaryDto).orElse(null);
    }

    private ReportSummaryDto createReportSummaryDto(ReportCriteria reportCriteria) {
        return ReportSummaryDto.builder()
                .criteria(dozerBeanMapper.map(reportCriteria, ReportCriteriaDto.class))
                .result(reportDtoFactory.create(reportCriteria.getReport()))
                .build();
    }
}
