package pl.softwareplant.report.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
public class ReportDto {

    @JsonProperty("film_id")
    private String filmId;
    @JsonProperty("film_name")
    private String filmName;
    @JsonProperty("character_id")
    private String characterId;
    @JsonProperty("character_name")
    private String characterName;
    @JsonProperty("planet_id")
    private String planetId;
    @JsonProperty("planet_name")
    private String planetName;
}
