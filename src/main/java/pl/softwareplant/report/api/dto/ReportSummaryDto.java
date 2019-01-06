package pl.softwareplant.report.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
public class ReportSummaryDto {

    private ReportCriteriaDto criteria;
    private ReportDto result;
}
