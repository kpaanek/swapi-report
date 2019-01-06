package pl.softwareplant.report.command.factory.provider;

import pl.softwareplant.report.domain.model.Report;
import pl.softwareplant.report.swapi.model.SwApiResult;

public interface ReportDataProvider {

    String URL_SPLIT_SEGMENT = "/";

    Class getSupportedClass();
    void provideData(Report report, SwApiResult swApiResult);

    default String getIdFromUrl(String url) {
        var splittedUrl = url.split(URL_SPLIT_SEGMENT);
        return splittedUrl[splittedUrl.length - 1];
    }
}
