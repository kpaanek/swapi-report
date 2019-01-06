package pl.softwareplant.report.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class ReportCriteriaDto {

    @NotNull
    private String characterPhrase;
    @NotNull
    private String planetName;
}
