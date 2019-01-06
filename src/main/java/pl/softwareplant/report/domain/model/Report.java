package pl.softwareplant.report.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Report {

    @EmbeddedId
    private ReportPrimaryKey reportPrimaryKey;
    @Column(name = "film_name")
    private String filmName;
    @Column(name = "character_name")
    private String characterName;
    @Column(name = "planet_name")
    private String planetName;
}
