package pl.softwareplant.report.command.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.softwareplant.report.command.factory.provider.ReportDataProvider;
import pl.softwareplant.report.domain.model.Report;
import pl.softwareplant.report.domain.model.ReportPrimaryKey;
import pl.softwareplant.report.swapi.model.SwApiResult;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ReportFactory {

    private Map<Class, ReportDataProvider> reportDataProviderMap;

    @Autowired
    public ReportFactory(List<ReportDataProvider> reportDataProviders) {
        this.reportDataProviderMap = reportDataProviders.stream()
                .collect(Collectors.toMap(ReportDataProvider::getSupportedClass, Function.identity()));
    }

    public Report create(List<SwApiResult> swApiResults) {
        var report = createEmptyReport();
        swApiResults.forEach(result -> reportDataProviderMap.get(result.getClass()).provideData(report, result));
        return report;
    }

    private Report createEmptyReport() {
        return Report.builder()
                .reportPrimaryKey(new ReportPrimaryKey())
                .build();
    }
}
