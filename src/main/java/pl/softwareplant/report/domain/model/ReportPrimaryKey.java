package pl.softwareplant.report.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReportPrimaryKey implements Serializable {

    @Column(name = "film_id")
    private String filmId;
    @Column(name = "character_id")
    private String characterId;
    @Column(name = "planet_id")
    private String planetId;
}
