package pl.softwareplant.report.command.factory.provider;

import org.springframework.stereotype.Component;
import pl.softwareplant.report.domain.model.Report;
import pl.softwareplant.report.swapi.model.Film;
import pl.softwareplant.report.swapi.model.SwApiResult;

@Component
public class FilmDataProvider implements ReportDataProvider {

    @Override
    public Class getSupportedClass() {
        return Film.class;
    }

    @Override
    public void provideData(Report report, SwApiResult swApiResult) {
        report.getReportPrimaryKey().setFilmId(getIdFromUrl(swApiResult.getUrl()));
        report.setFilmName(swApiResult.getName());
    }
}
