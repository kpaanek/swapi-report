package pl.softwareplant.report.command.factory.provider;

import org.springframework.stereotype.Component;
import pl.softwareplant.report.domain.model.Report;
import pl.softwareplant.report.swapi.model.Person;
import pl.softwareplant.report.swapi.model.SwApiResult;

@Component
public class PersonDataProvider implements ReportDataProvider {

    @Override
    public Class getSupportedClass() {
        return Person.class;
    }

    @Override
    public void provideData(Report report, SwApiResult swApiResult) {
        report.getReportPrimaryKey().setCharacterId(getIdFromUrl(swApiResult.getUrl()));
        report.setCharacterName(swApiResult.getName());
    }
}
