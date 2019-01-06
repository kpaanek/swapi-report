package pl.softwareplant.report.swapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Film implements SwApiResult {

    private String title;
    private String url;

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
