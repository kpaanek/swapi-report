package pl.softwareplant.report.command.factory.provider;

import org.springframework.stereotype.Component;
import pl.softwareplant.report.domain.model.Report;
import pl.softwareplant.report.swapi.model.Planet;
import pl.softwareplant.report.swapi.model.SwApiResult;

@Component
public class PlanetDataProvider implements ReportDataProvider {

    @Override
    public Class getSupportedClass() {
        return Planet.class;
    }

    @Override
    public void provideData(Report report, SwApiResult swApiResult) {
        report.getReportPrimaryKey().setPlanetId(getIdFromUrl(swApiResult.getUrl()));
        report.setPlanetName(swApiResult.getName());
    }
}
