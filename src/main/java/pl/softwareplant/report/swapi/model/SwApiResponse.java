package pl.softwareplant.report.swapi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SwApiResponse<T extends SwApiResult> {

    private int count;
    private List<T> results;
}
