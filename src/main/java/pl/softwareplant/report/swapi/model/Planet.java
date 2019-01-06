package pl.softwareplant.report.swapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Planet implements SwApiResult {

    private String name;
    private String url;
    @JsonProperty("films")
    private Set<String> filmUrls;
}
